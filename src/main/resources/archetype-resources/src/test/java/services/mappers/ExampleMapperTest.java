package ${package}.services.mappers;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import ${package}.models.entities.ExampleEntity;
import ${package}.models.input.NewExampleDTO;
import ${package}.models.output.ExampleDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExampleMapperTest {

    @Spy
    private ExampleMapperImpl exampleMapper;

    @Nested
    class MapToExampleEntity {

        @Test
        public void whenMapToExampleEntity_shouldReturnExampleEntity() {
            // Given
            NewExampleDTO newExampleDTO = new NewExampleDTO("Example");
            ExampleEntity expectedExampleEntity = ExampleEntity.builder().name("Example").build();

            // Then
            ExampleEntity actualExampleEntity = exampleMapper.mapToExampleEntity(newExampleDTO);

            // Assert
            assertEquals(expectedExampleEntity, actualExampleEntity);
        }

    }

    @Nested
    class MapToExampleDTO {

        @Test
        public void whenMapToExampleDTO_shouldReturnExampleDTO() {
            // Given
            OffsetDateTime createdAt = OffsetDateTime.of(2021, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            ExampleEntity exampleEntity = ExampleEntity.builder()
                                                       .name("Example")
                                                       .createdAt(createdAt)
                                                       .build();
            ExampleDTO expectedExampleDTO = new ExampleDTO("Example", createdAt);

            // Then
            ExampleDTO actualExampleDTO = exampleMapper.mapToExampleDTO(exampleEntity);

            // Assert
            assertEquals(expectedExampleDTO, actualExampleDTO);
        }

    }

}
