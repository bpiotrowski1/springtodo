package pl.bpiotrowski.springtodo.dto;

import lombok.Data;
import pl.bpiotrowski.springtodo.entity.Priority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TodoDto {

    @NotBlank
    @Size(min = 3)
    private String description;

    @NotNull
    private Priority priority;

}
