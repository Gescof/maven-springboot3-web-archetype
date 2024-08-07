package ${package}.models;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;

public record ErrorResponseDTO(OffsetDateTime timestamp, HttpStatus status, String message) {
}
