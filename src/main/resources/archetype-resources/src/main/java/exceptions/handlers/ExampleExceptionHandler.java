package ${package}.exceptions.handlers;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ${package}.exceptions.ExampleNotFoundException;
import ${package}.models.output.ErrorResponseDTO;

@RestControllerAdvice
public class ExampleExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidExceptionException(final MethodArgumentNotValidException ex) {
        String message = ex.getMessage();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.BAD_REQUEST, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    @ExceptionHandler(ExampleNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleExampleNotFoundException(final ExampleNotFoundException ex) {
        String message = ex.getMessage();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.NOT_FOUND, message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(final Exception ex) {
        String message = ex.getMessage();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }

}
