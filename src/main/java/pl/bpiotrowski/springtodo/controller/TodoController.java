package pl.bpiotrowski.springtodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public Collection<Todo> findAll() {
        return todoService.find();
    }

    @GetMapping("/{id}")
    public Todo find(@PathVariable Long id) {
        return todoService.find(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        todoService.create(todo);
        return todo;
    }

    @PutMapping("/{id}")
    public Todo update(@RequestBody Todo todo, @PathVariable Long id) {
        todo.setId(id);
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}
