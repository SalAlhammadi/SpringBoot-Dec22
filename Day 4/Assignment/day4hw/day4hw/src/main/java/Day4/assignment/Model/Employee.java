package Day4.assignment.Model;

import jakarta.validation.constraints.*;
import jakarta.websocket.OnError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

@Data @AllArgsConstructor

public class Employee {
    @NotNull
    @Size(min = 2, message = "ID is too short")
    private float ID;
    @NotNull
    @Size(min = 4, message = "name is too short, has to be more than 4 characters")
    private String name;

    @NotNull
    @Min(25)
    private int age;
    @NotNull
    @AssertFalse
    private Boolean onLeave;
    @NotNull
    @Range(min = 2000)
    private int empYear;
    @NotNull
    private int annLeave;
}
