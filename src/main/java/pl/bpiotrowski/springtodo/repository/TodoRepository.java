package pl.bpiotrowski.springtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.bpiotrowski.springtodo.entity.Priority;
import pl.bpiotrowski.springtodo.entity.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("select t from Todo t where t.priority=:priority")
    List<Todo> findAllByPriority(@Param("priority") Priority priority);

}
