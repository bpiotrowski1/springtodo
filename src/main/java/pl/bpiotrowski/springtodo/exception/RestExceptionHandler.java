package pl.bpiotrowski.springtodo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.bpiotrowski.springtodo.dto.ErrorDto;

import javax.validation.ConstraintViolationException;
import java.net.BindException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorDto handlerNotFoundException(EntityNotFoundException ex) {
        return handleException(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ErrorDto handlerBadRequestException(Exception ex) {
        return handleException(ex);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ErrorDto handleGeneralException(Exception ex) {
        return handleException(ex);
    }

    private ErrorDto handleException(Exception ex) {
        log.error("Exception handled", ex);
        ErrorDto error = new ErrorDto();
        error.setExceptionClass(ex.getClass().getCanonicalName());
        error.setMessage(ex.getMessage());
        return error;
    }
}
