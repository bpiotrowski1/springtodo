package pl.bpiotrowski.springtodo.entity;

import lombok.Data;

@Data
public class Todo {
    String id;
    String description;
    String finishDate;
    Priority priority;
    boolean done;
    int order;
}
