package ${package}.exceptions;

import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
public class ExampleNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
}
