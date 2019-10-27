package pl.bpiotrowski.springtodo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bpiotrowski.springtodo.entity.Todo;
import pl.bpiotrowski.springtodo.repository.TodoRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}
