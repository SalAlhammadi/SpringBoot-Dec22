package day4.exercise.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "Name is empty.")
    @Size(min= 4, max = 10, message = "Name should be between 4 and 10 characters long.")
    private String name;

    @NotEmpty(message = "Password is empty.")
    @Size(min= 4, max = 8, message = "Password should be between 4 and 8 characters long.")
    private String password;
}

