package com.project.plusserver.dto;

public class OutputDto extends InputDto{
    private Character operation;
    private Integer result;

    public Character getOperation() {
        return operation;
    }

    public void setOperation(Character operation) {
        this.operation = operation;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
