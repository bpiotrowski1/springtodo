package pl.bpiotrowski.springtodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.bpiotrowski.springtodo.entity.Priority;
import pl.bpiotrowski.springtodo.entity.Todo;
import pl.bpiotrowski.springtodo.service.TodoService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestTodoController {

    private final TodoService todoService;

    @GetMapping
    public Collection<Todo> findAll(String filter) {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo find(@PathVariable Long id) {
        return todoService.find(id);
    }

    @GetMapping("/priority/{priority}")
    public Collection<Todo> findAllByPriority(@PathVariable(required = false) Priority priority) {
        return todoService.findAllByPriority(priority);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Todo create(@Validated @RequestBody Todo todo) {
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
