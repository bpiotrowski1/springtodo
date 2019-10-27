package pl.bpiotrowski.springtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends RuntimeException {

    private Long id;
    private String message;

    public EntityNotFoundException(Long id) {
        super("Entity with id " + id + " not found");
    }
}
