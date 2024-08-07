package ${package}.services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ${package}.exceptions.ExampleNotFoundException;
import ${package}.models.entities.ExampleEntity;
import ${package}.models.input.NewExampleDTO;
import ${package}.models.output.ExampleDTO;
import ${package}.repositories.ExampleRepository;
import ${package}.services.mappers.ExampleMapperImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExampleServiceImplTest {

    @Mock
    private ExampleRepository exampleRepository;

    @Mock
    private ExampleMapperImpl exampleMapper;

    @InjectMocks
    private ExampleServiceImpl exampleService;

    @Nested
    class CreateExample {

        @Test
        void whenCreateExample_shouldSaveExampleEntity() {
            // Given
            NewExampleDTO newExampleDTO = new NewExampleDTO("Example");
            ExampleEntity expectedExampleEntity = ExampleEntity.builder().name("Example").build();

            // When
            doReturn(expectedExampleEntity).when(exampleMapper).mapToExampleEntity(newExampleDTO);

            // Then
            exampleService.createExample(newExampleDTO);

            // Assert
            verify(exampleRepository).save(expectedExampleEntity);
        }

    }

    @Nested
    class GetExample {

        @Test
        void whenGetExample_shouldReturnExampleDTO() {
            // Given
            Long id = 1L;
            OffsetDateTime createdAt = OffsetDateTime.of(2021, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            OffsetDateTime updatedAt = OffsetDateTime.of(2021, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            ExampleEntity exampleEntity = ExampleEntity.builder().id(id).name("Example")
                    .createdAt(createdAt).updatedAt(updatedAt).build();
            ExampleDTO expectedExampleDTO = new ExampleDTO("Example", createdAt);

            // When
            doReturn(Optional.of(exampleEntity)).when(exampleRepository).findById(id);
            doReturn(expectedExampleDTO).when(exampleMapper).mapToExampleDTO(exampleEntity);

            // Then
            ExampleDTO actualExampleDTO = exampleService.getExample(id);

            // Assert
            assertEquals(expectedExampleDTO, actualExampleDTO);
        }

        @Test
        void whenGetExample_shouldThrowExampleNotFoundException() {
            // Given
            Long id = 1L;

            // When
            doReturn(Optional.empty()).when(exampleRepository).findById(id);

            // Then
            assertThrows(ExampleNotFoundException.class, () -> exampleService.getExample(id));
        }

    }

}
