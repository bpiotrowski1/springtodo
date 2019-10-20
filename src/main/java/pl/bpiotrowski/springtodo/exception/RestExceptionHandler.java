package pl.bpiotrowski.springtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.bpiotrowski.springtodo.dto.ErrorDto;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorDto handlerNotFoundException(EntityNotFoundException ex) {
        ErrorDto error = new ErrorDto();
        error.setExceptionClass(ex.getClass().getCanonicalName());
        error.setMessage(ex.getMessage());

        return error;
    }
}
