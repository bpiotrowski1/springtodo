package pl.bpiotrowski.springtodo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.bpiotrowski.springtodo.entity.Todo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class TodoService {

    private Map<String, Todo> tasks = new HashMap<>();

    public Collection<Todo> findAll() {
        return tasks.values();
    }

    public Todo findTask(String id) {
        return tasks.get(id);
    }

    public void addTask(Todo todo) {
        tasks.put(todo.getId(), todo);
    }

    public void deleteTask(String id) {
        tasks.remove(id);
    }

    public Todo updateTask(String id, Todo todo) {
        tasks.remove(id);
        todo.setId(id);
        addTask(todo);
        return todo;
    }
}
