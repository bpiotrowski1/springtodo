package pl.bpiotrowski.springtodo.entity;

import lombok.Data;

@Data
public class Todo {
    private String id;
    private String description;
    private String finishDate;
    private Priority priority;
    private boolean done;
    private int orderPriority;
}
