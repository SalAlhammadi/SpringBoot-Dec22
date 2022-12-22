package Pizza.Controllers;

import Pizza.Models.User.Customer;
import Pizza.Models.Pizza;
import Pizza.Services.CustomerService;
import Pizza.Services.PizzaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final PizzaService pizzaService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
             customerService.addCustomer(customer);
            return ResponseEntity.status(200).body("Customer added");

    }

    @GetMapping("/all")
    public ResponseEntity getCustomer(){
        return ResponseEntity.status(200).body(customerService.getAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@RequestBody @Valid Customer customer,@PathVariable Integer id, Errors er){
        if(!er.hasErrors())
        {
            if(customerService.isCustomer(id)){
                customerService.updateCustomer(id,customer);
                return ResponseEntity.status(202).body("Customer was update");
            }
            else
                return ResponseEntity.status(400).body("Customer not found");

        }
        else return ResponseEntity.status(200).body(er.getFieldError().getDefaultMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        if(customerService.isCustomer(id)){
            customerService.deleteCustomer(id);
            return ResponseEntity.status(202).body("Customer was deleted");
        }
        else
            return ResponseEntity.status(400).body("Customer not found");

    }
    @PostMapping("/order/pizza")
    public ResponseEntity addPizza(@RequestBody @Valid Pizza pizza){
        pizzaService.addPizza(pizza);
        return ResponseEntity.status(200).body("Pizza added");

    }
    @GetMapping("/bill/{id}")
    public ResponseEntity getBill(@PathVariable Integer id){
        return ResponseEntity.status(200).body(pizzaService.getPrice(id));
    }

}
