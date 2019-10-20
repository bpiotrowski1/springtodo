package pl.bpiotrowski.springtodo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bpiotrowski.springtodo.entity.Priority;
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

    public Collection<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo find(Long id) {
        return todoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id)
        );
    }

    public Collection<Todo> findAllByPriority(Priority priority) {
        if(priority == null) {
            return todoRepository.findAll();
        }

        return todoRepository.findAllByPriority(priority);
    }

    public void create(Todo todo) {
        todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo update(Todo todo) {
        delete(todo.getId());
        create(todo);
        return null;
    }
}
