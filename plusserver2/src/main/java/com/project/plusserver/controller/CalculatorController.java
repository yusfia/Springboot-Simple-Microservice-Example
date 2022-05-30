package com.project.plusserver.controller;

import com.project.plusserver.dto.InputDto;
import com.project.plusserver.dto.OutputDto;
import com.project.plusserver.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calc")
    public ResponseEntity<OutputDto> calculatorEndPoint(@RequestBody InputDto input){
        Integer result = calculatorService.calculateResult(input);
        OutputDto output = new OutputDto();
        output.setA(input.getA());
        output.setB(input.getB());
        output.setOperation('+');
        output.setResult(result);
        logger.info("a = "+input.getA()+", b = "+input.getB()+", operation = +, Port = "+ serverPort);
        return ResponseEntity.ok(output);
    }
}
