package pl.bpiotrowski.springtodo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bpiotrowski.springtodo.entity.Todo;
import pl.bpiotrowski.springtodo.exception.EntityNotFoundException;
import pl.bpiotrowski.springtodo.repository.TodoRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private Map<Long, Todo> tasks = new HashMap<>();

    public Collection<Todo> find() {
        return todoRepository.findAll();
        //return tasks.values();
    }

    public Todo find(Long id) {
//        Todo todo = tasks.get(id);
//        if(todo == null) {
//            throw new EntityNotFoundException(id);
//        }
//
//        return todo;
        return todoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id)
        );
    }

    public void create(Todo todo) {
        todoRepository.save(todo);
        //tasks.put(todo.getId(), todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
        //tasks.remove(id);
    }

    public Todo update(Todo todo) {
        delete(todo.getId());
        create(todo);
        return null;
    }
}
