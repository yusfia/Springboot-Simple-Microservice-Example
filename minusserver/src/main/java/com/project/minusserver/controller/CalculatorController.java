package com.project.minusserver.controller;

import com.project.minusserver.dto.InputDto;
import com.project.minusserver.dto.OutputDto;
import com.project.minusserver.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calc")
    public ResponseEntity<OutputDto> calculatorEndPoint(@RequestBody InputDto inputDto){
        Integer result = calculatorService.calculateResult(inputDto);
        OutputDto outputDto = new OutputDto();
        outputDto.setOperation('-');
        outputDto.setResult(result);
        outputDto.setA(inputDto.getA());
        outputDto.setB(inputDto.getB());
        logger.info("a = "+inputDto.getA()+", b = "+inputDto.getB()+", operation = -, Port = "+ serverPort);
        return ResponseEntity.ok(outputDto);
    }
}
