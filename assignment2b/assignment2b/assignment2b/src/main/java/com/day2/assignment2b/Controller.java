package com.day2.assignment2b;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1")
public class Controller {
    ArrayList<Task> myDB = new ArrayList<Task>();

    @GetMapping("/getAll")
    public ArrayList<Task> getTasks(){
        return myDB;
    }

    @PostMapping("/addTask")
    public  Response addTask(@RequestBody Task task){
        myDB.add(task);
        return new Response("the task was created");
    }
    @GetMapping("/getTask/{title}")
    public Response getTask(@PathVariable String title){
        Task tempTask = null;
        for ( int i = 0 ; i < myDB.size();i++){
            if (myDB.get(i).getTitle().contains(title)) //to resolve spaces in the inputs
                tempTask = myDB.get(i);
                break;
        }
        return new Response(tempTask.toString());
    }
    @PutMapping("/update/{index}/{status}") //can be used to update status as well as any other changes.
    public Response updateTask(@PathVariable int index, @PathVariable String status) {
        myDB.get(index).setStatus(status);
        return new Response("task was updated successfully");
    }
    @DeleteMapping("/delete/{index}")
    public Response deleteTask(@PathVariable int i){
        String tempName = myDB.get(i).getTitle();
        myDB.remove(i);
        return  new Response(tempName + " was deleted successfully");
    }

}
