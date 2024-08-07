package ${package}.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ${package}.models.entities.ExampleEntity;
import ${package}.models.input.NewExampleDTO;
import ${package}.models.output.ExampleDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExampleMapper {

    @Mapping(target = "name", source = "name")
    ExampleEntity mapToExampleEntity(NewExampleDTO exampleDTO);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdAt", source = "createdAt")
    ExampleDTO mapToExampleDTO(ExampleEntity exampleEntity);

}
