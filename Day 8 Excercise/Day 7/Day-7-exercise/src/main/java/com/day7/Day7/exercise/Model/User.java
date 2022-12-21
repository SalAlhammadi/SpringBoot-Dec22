package com.day7.Day7.exercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min=4)
    private String name, password;
    @NotNull
    @Size(min=4)
    @Column(unique = true)
    private String username;
    @NotNull
    @Pattern(regexp = "(admin|user)")
    private String role;
    @NotNull
    @Pattern(regexp = "^(.+)@(\\S+)$")
    @Column(unique = true)
    private String email;
    @NotNull
    private int age;
}
