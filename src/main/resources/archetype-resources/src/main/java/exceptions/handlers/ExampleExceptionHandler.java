package ${package}.exceptions.handlers;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ${package}.exceptions.ExampleNotFoundException;
import ${package}.exceptions.ExampleServerException;
import ${package}.models.output.ErrorResponseDTO;

@RestControllerAdvice
public class ExceptionHandler {

    @ExceptionHandler(ExampleNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleExampleNotFoundExceptionException(ExampleNotFoundException e) {
        String message = e.getMessage();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.NOT_FOUND, message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    @ExceptionHandler(ExampleServerException.class)
    public ResponseEntity<ErrorResponseDTO> handleExampleServerException(ExampleServerException e) {
        String message = e.getMessage();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }

}
