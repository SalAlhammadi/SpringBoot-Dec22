package com.day7.Day7.exercise.Controller;


import com.day7.Day7.exercise.Model.User;
import com.day7.Day7.exercise.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors er){
        if(!er.hasErrors())
        {
            userService.addUser(user);
            return ResponseEntity.status(200).body("User added");
        }
        else return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
    }

    @GetMapping("/all")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user,@PathVariable Integer id, Errors er){
        if(!er.hasErrors())
        {
            if(userService.isUser(id)){
                userService.updateUser(id,user);
                return ResponseEntity.status(202).body("user was update");
            }
            else
                return ResponseEntity.status(400).body("User not found");

        }
        else return ResponseEntity.status(200).body(er.getFieldError().getDefaultMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        if(userService.isUser(id)){
            userService.deleteUser(id);
            return ResponseEntity.status(202).body("user was deleted");
        }
        else
            return ResponseEntity.status(400).body("User not found");

    }
}
