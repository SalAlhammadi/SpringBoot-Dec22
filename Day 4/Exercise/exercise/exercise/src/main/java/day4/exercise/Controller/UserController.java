package day4.exercise.Controller;

import day4.exercise.Model.User;
import day4.exercise.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    ArrayList<User> myDB = new ArrayList<User>();

    @GetMapping("/get")
    public ArrayList<User> getUsers(){
        return myDB;
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        else
            myDB.add(user);
        return ResponseEntity.status(201).body(new Response("the user " + user.getName() + " was created."));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid @PathVariable int index, @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        else
        {
            myDB.set(index,user);
            return ResponseEntity.status(200).body(new Response("the user " + user.getName() + "was updated."));
        }
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity delUser(@PathVariable int index){
        String name = myDB.get(index).getName();
        myDB.remove(index);
        return ResponseEntity.status(200).body(new Response("the user " + name + " was deleted!"));
    }

}
