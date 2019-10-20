package pl.bpiotrowski.springtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bpiotrowski.springtodo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
