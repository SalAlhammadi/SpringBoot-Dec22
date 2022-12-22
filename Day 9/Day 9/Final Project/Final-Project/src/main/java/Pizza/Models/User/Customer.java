package Pizza.Models.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    @Pattern(regexp = "^(.+)@(\\S+)$")
    @Column(unique = true)
    private String email;
    @NotNull
    @Pattern(regexp = "05[0-9]{8}")
    @Column(unique = true)
    private String phone;



}
