package ${package}.controllers;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ${package}.models.input.NewExampleDTO;
import ${package}.models.output.ExampleDTO;
import ${package}.services.impl.ExampleServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ExampleControllerTest {

    @Mock
    private ExampleServiceImpl exampleService;

    @InjectMocks
    private ExampleController controller;

    @Nested
    class CreateExample {

        @Test
        void whenCreateExample_shouldReturnCreatedResponse() {
            // Given
            NewExampleDTO newExample = new NewExampleDTO("Example");

            // When
            doNothing().when(exampleService).createExample(newExample);

            // Then
            ResponseEntity<Void> response = controller.createExample(newExample);

            // Assert
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        }

    }

    @Nested
    class GetExample {

        @Test
        void whenGetExample_shouldReturnOkResponse() {
            // Given
            Long id = 1L;
            OffsetDateTime createdAt = OffsetDateTime.of(2021, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            ExampleDTO expectedExampleDTO = new ExampleDTO("Example", createdAt);

            // When
            doReturn(expectedExampleDTO).when(exampleService).getExample(id);

            // Then
            ResponseEntity<ExampleDTO> response = controller.getExample(id);

            // Assert
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }

    }

}
