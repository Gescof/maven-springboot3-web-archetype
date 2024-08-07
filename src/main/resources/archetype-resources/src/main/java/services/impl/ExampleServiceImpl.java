package ${package}.services.impl;

import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ${package}.exceptions.ExampleNotFoundException;
import ${package}.models.entities.ExampleEntity;
import ${package}.models.input.NewExampleDTO;
import ${package}.models.output.ExampleDTO;
import ${package}.repositories.ExampleRepository;
import ${package}.services.ExampleService;
import ${package}.services.mappers.ExampleMapper;

@Log4j2
@RequiredArgsConstructor
@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;
    private final ExampleMapper exampleMapper;

    @Override
    public void createExample(final NewExampleDTO newExample) {
        ExampleEntity example = exampleMapper.mapToExampleEntity(newExample);
        exampleRepository.save(example);
    }

    @Override
    public ExampleDTO getExample(final Long id) {
        ExampleEntity example = exampleRepository.findById(id).orElseThrow(
                () -> ExampleNotFoundException.builder().message("Example not found").build());
        return exampleMapper.mapToExampleDTO(example);
    }

}
