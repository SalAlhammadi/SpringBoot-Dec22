package Pizza.Models.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cashier {
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

    @Column(name = "timestamp" , insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;



}
