package pl.bpiotrowski.springtodo.dto;

import lombok.Data;

@Data
public class ErrorDto {

    private String message;
    private String exceptionClass;
}
