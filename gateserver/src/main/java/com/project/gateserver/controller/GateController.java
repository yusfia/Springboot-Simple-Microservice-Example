package com.project.gateserver.controller;

import com.project.gateserver.dto.ResultDto;
import com.project.gateserver.dto.TransferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class GateController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/{a}/{operator}/{b}")
    public ResponseEntity<ResultDto> calculatorEndPoint(@PathVariable("a") Integer a,
                                                        @PathVariable("operator") Character operation,
                                                        @PathVariable("b") Integer b)
    {
        ServiceInstance serviceInstance;
        TransferDto transferDto = new TransferDto();
        transferDto.setA(a);
        transferDto.setB(b);
        switch (operation) {
            case '+': serviceInstance = loadBalancer.choose("plus-server"); break;
            case '-': serviceInstance = loadBalancer.choose("minus-server"); break;
            default: serviceInstance = loadBalancer.choose("plus-server"); break;
        }
        String selectedUrl = serviceInstance.getUri().toString();
        //http://locahost:2000, http://localhost:3000, http://localhost:4000, http://localhost:5000
        String baseUrl = selectedUrl+"/calc";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultDto> response = restTemplate.postForEntity(baseUrl, transferDto, ResultDto.class);
        ResultDto resultDto = response.getBody();
        return ResponseEntity.ok(resultDto);
    }

}
