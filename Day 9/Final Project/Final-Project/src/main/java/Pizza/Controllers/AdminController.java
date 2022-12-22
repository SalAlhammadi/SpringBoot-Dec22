package Pizza.Controllers;

import Pizza.Models.User.Admin;
import Pizza.Models.Pizza;
import Pizza.Services.AdminService;
import Pizza.Services.PizzaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final PizzaService pizzaService;

    @PostMapping("/add")
    public ResponseEntity addAdmin(@RequestBody @Valid Admin admin){
            adminService.addAdmin(admin);
            return ResponseEntity.status(200).body("Admin added");
    }


    @GetMapping("/all")
    public ResponseEntity getAdmin(){
        return ResponseEntity.status(200).body(adminService.getAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAdmin(@RequestBody @Valid Admin admin,@PathVariable Integer id) {
        if (adminService.isAdmin(id)) {
            adminService.updateAdmin(id, admin);
            return ResponseEntity.status(202).body("Admin was update");
        }
        else return ResponseEntity.status(400).body("Admin not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAdmin(@PathVariable Integer id){
        if(adminService.isAdmin(id)){
            adminService.deleteAdmin(id);
            return ResponseEntity.status(202).body("Admin was deleted");
        }
        else
            return ResponseEntity.status(400).body("Admin not found");

    }
    @GetMapping("/sales")
    public ResponseEntity getSales(){
        double sales=0;
        for (Pizza pizza: pizzaService.getAll()) {
            sales +=pizza.getPrice();
        }
        return ResponseEntity.status(200).body("total sales: " + sales + " SAR");
    }



}
