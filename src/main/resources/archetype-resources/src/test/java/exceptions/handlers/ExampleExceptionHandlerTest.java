package ${package}.exceptions.handlers;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import ${package}.exceptions.ExampleNotFoundException;
import ${package}.models.output.ErrorResponseDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ExampleExceptionHandlerTest {

    @Spy
    private ExampleExceptionHandler exampleExceptionHandler;

    @Nested
    class HandleMethodArgumentNotValidException {

        @Test
        public void whenHandleMethodArgumentNotValidException_shouldReturnBadRequestResponse() {
            // Given
            MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
            ErrorResponseDTO expectedErrorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.BAD_REQUEST, ex.getMessage());
            ResponseEntity<ErrorResponseDTO> expectedResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(expectedErrorResponseDTO);

            // When
            ResponseEntity<ErrorResponseDTO> actualResponse = exampleExceptionHandler.handleMethodArgumentNotValidExceptionException(ex);

            // Assert
            assertErrorResponseDTO(expectedResponse, actualResponse);
        }

    }

    @Nested
    class HandleExampleNotFoundException {

        @Test
        public void whenHandleExampleNotFoundException_shouldReturnNotFoundResponse() {
            // Given
            ExampleNotFoundException ex = ExampleNotFoundException.builder().message("Example not found").build();
            ErrorResponseDTO expectedErrorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage());
            ResponseEntity<ErrorResponseDTO> expectedResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(expectedErrorResponseDTO);

            // When
            ResponseEntity<ErrorResponseDTO> actualResponse = exampleExceptionHandler.handleExampleNotFoundException(ex);

            // Assert
            assertErrorResponseDTO(expectedResponse, actualResponse);
        }

    }

    @Nested
    class HandleException {

        @Test
        public void whenHandleException_shouldReturnInternalServerErrorResponse() {
            // Given
            Exception ex = new Exception("Internal server error");
            ErrorResponseDTO expectedErrorResponseDTO = new ErrorResponseDTO(OffsetDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
            ResponseEntity<ErrorResponseDTO> expectedResponse = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(expectedErrorResponseDTO);

            // When
            ResponseEntity<ErrorResponseDTO> actualResponse = exampleExceptionHandler.handleException(ex);

            // Assert
            assertErrorResponseDTO(expectedResponse, actualResponse);
        }

    }

    private void assertErrorResponseDTO(ResponseEntity<ErrorResponseDTO> expected, ResponseEntity<ErrorResponseDTO> actual) {
        assertEquals(expected.getStatusCode(), actual.getStatusCode());
        assertEquals(expected.getBody().status(), actual.getBody().status());
        assertEquals(expected.getBody().message(), actual.getBody().message());
    }

}
