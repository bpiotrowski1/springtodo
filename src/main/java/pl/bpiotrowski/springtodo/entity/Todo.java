package pl.bpiotrowski.springtodo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "tasks")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String description;

    private String finishDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Priority priority;

    private boolean done;
    private int orderPriority;
}
