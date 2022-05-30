package com.project.minusserver.service;

import com.project.minusserver.dto.InputDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer calculateResult(InputDto inputDto){
        return inputDto.getA() - inputDto.getB();
    }
}
