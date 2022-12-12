package com.SpringBootCamp.Assignment1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/name")
    public String getName(){
        return "My name is Salem Alhammadi";
    }
    @GetMapping("/age")
    public String getAge(){
        return "My age is 24";
    }
    @GetMapping("/check/status")
    public String getStatus(){
        return "Everything is OK";
    }

    @GetMapping("/health")
    public String getHealth(){
        return "Server health is up and running";
    }
}
