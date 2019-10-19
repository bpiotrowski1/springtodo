package pl.bpiotrowski.springtodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bpiotrowski.springtodo.entity.Todo;
import pl.bpiotrowski.springtodo.service.TodoService;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public Collection<Todo> findAllTasks() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo findTask(@PathVariable String id) {
        return todoService.findTask(id);
    }

    @PostMapping
    public Todo addTask(@RequestBody Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todoService.addTask(todo);
        return todo;
    }

    @PostMapping("/update/{id}")
    public Todo updateTask(@PathVariable String id, @RequestBody Todo todo) {
        return todoService.updateTask(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        todoService.deleteTask(id);
    }
}
