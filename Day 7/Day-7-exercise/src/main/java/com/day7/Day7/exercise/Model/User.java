package com.day7.Day7.exercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Entity @NoArgsConstructor
public class User {
    //User class: ID , name , username , password, email ,role, age
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name, username, password,role;
    @NotNull
    @Pattern(regexp = "\\w+@\\w+\\.\\w")
    private String email;
    @NotNull
    private int age;
}
