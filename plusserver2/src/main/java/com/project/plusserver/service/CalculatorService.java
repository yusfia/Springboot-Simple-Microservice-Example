package com.project.plusserver.service;

import com.project.plusserver.dto.InputDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer calculateResult(InputDto input){
        return input.getA() + input.getB();
    }
}
