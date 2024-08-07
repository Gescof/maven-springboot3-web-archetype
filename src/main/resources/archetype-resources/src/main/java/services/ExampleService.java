package ${package}.services;

import ${package}.models.input.NewExampleDTO;
import ${package}.models.output.ExampleDTO;

public interface ExampleService {

    void createExample(final NewExampleDTO newExample);

    ExampleDTO getExample(final Long id);

}
