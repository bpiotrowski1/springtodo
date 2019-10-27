package pl.bpiotrowski.springtodo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.bpiotrowski.springtodo.dto.TodoDto;
import pl.bpiotrowski.springtodo.entity.Priority;
import pl.bpiotrowski.springtodo.entity.Todo;
import pl.bpiotrowski.springtodo.entity.User;
import pl.bpiotrowski.springtodo.exception.EntityNotFoundException;
import pl.bpiotrowski.springtodo.repository.TodoRepository;
import pl.bpiotrowski.springtodo.repository.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public Collection<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Collection<TodoDto> findAllByUserUsername(String username) {
        return todoRepository.findAllByUserUsername(username).stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private TodoDto map(Todo todo) {
        TodoDto dto = new TodoDto();
        dto.setDescription(todo.getDescription());
        dto.setPriority(todo.getPriority());
        dto.setFinishDate(todo.getFinishDate());
        dto.setId(todo.getId());
        return dto;
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

    public void create(TodoDto dto, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
        Todo entity = new Todo();
        entity.setDescription(dto.getDescription());
        entity.setPriority(dto.getPriority());
        entity.setUser(user);
        todoRepository.save(entity);
    }

    public void create(Todo todo) {
        todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo update(Todo todo) {
        todoRepository.save(todo);
        return todo;
    }
}
