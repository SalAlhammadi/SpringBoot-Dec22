package Day4.assignment.Controller;

import Day4.assignment.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1")
public class EmpController {
    ArrayList<Employee> myDB = new ArrayList<Employee>();
    @GetMapping("/getAll")
    public ArrayList<Employee> getAll(){
        return myDB;
    }

    @PostMapping("/addEmp")
    public ResponseEntity addEmp(@RequestBody Employee emp, Errors err){

        if(err.hasErrors()){
            return ResponseEntity.status(400).body(err.getFieldError()
                    .getDefaultMessage());
        }
        myDB.add(emp);
        System.out.print("I got here");

        return ResponseEntity.status(201).body("Employee added successfully");
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmp(@PathVariable int index, @RequestBody @Valid Employee emp, Errors err){

        if(err.hasErrors())
            return ResponseEntity.status(400).body(err.getFieldError()
                    .getDefaultMessage());
        else
            myDB.set(index,emp);

        return ResponseEntity.status(202).body("Employee updated successfully");
    }

    @DeleteMapping("/deleteEmp/{index}")
    public ResponseEntity deleteEmp(int index){
        myDB.remove(index);
        return ResponseEntity.status(203)
                .body("Employee removed successfully");
    }
    @PutMapping("/update/{ID}/leave/{days}")
    public ResponseEntity takeLeave(@PathVariable float ID, @PathVariable int days){
        Employee tempEmp = null;
        int link =0;

        for (int i = 0 ; i< myDB.size();i++){

            if (myDB.get(i).getID() == ID){
                link = i;

                if (myDB.get(i).getAnnLeave() > days)
                {
                    myDB.get(i).setOnLeave(true);
                    myDB.get(i).setAnnLeave(myDB.get(i).getAnnLeave()-days);
                    return ResponseEntity.status(202)
                            .body("Enjoy your vacation!");
                }
                else
                    return ResponseEntity.status(200)
                            .body("Emp doesn't have enough leaves.");
            }
            else return ResponseEntity.status(404)
                    .body("Employee not found");
        }

        return ResponseEntity.status(201).body("I will check with HR and get back to you.");
    }
}
