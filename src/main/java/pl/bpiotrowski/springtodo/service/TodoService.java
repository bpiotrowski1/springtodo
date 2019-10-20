package pl.bpiotrowski.springtodo.service;

import org.springframework.stereotype.Service;
import pl.bpiotrowski.springtodo.entity.Todo;
import pl.bpiotrowski.springtodo.exception.EntityNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TodoService {

    private Map<String, Todo> tasks = new HashMap<>();

    public Collection<Todo> find() {
        return tasks.values();
    }

    public Todo find(String id) {
        Todo todo = tasks.get(id);
        if(todo == null) {
            throw new EntityNotFoundException(id);
        }

        return todo;
    }

    public void create(Todo todo) {
        tasks.put(todo.getId(), todo);
    }

    public void delete(String uuid) {
        tasks.remove(uuid);
    }

    public Todo update(Todo todo) {
        tasks.remove(todo.getId());
        create(todo);
        return todo;
    }
}
