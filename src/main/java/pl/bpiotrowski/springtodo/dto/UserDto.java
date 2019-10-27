package pl.bpiotrowski.springtodo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotBlank
    @Size(min = 4, max = 255)
    private String username;

    @NotBlank
    @Size(min = 6, max = 255)
    private String password;

}
