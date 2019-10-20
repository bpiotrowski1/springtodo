package pl.bpiotrowski.springtodo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String finishDate;

    @Enumerated
    private Priority priority;

    private boolean done;
    private int orderPriority;
}
