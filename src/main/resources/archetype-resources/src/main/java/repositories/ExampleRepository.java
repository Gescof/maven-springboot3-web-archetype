package ${package}.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ${package}.models.entities.ExampleEntity;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {
}
