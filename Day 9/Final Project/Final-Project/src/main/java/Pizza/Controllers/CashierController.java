package Pizza.Controllers;

import Pizza.Models.Pizza;
import Pizza.Models.User.Cashier;
import Pizza.Services.CashierService;
import Pizza.Services.PizzaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cashier")
@RequiredArgsConstructor
public class CashierController {

    private final CashierService cashierService;
    private final PizzaService pizzaService;

    @PostMapping("/add")
    public ResponseEntity addCashier(@RequestBody @Valid Cashier cashier){
            cashierService.addCashier(cashier);
            return ResponseEntity.status(200).body("Cashier added");
        }

    @GetMapping("/all")
    public ResponseEntity getCashier(){
        return ResponseEntity.status(200).body(cashierService.getAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCashier(@RequestBody @Valid Cashier cashier,@PathVariable Integer id, Errors er) {
        if (cashierService.isCashier(id)) {
            cashierService.updateCashier(id, cashier);
            return ResponseEntity.status(202).body("Cashier was update");
        } else
            return ResponseEntity.status(400).body("Cashier not found");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCashier(@PathVariable Integer id){
        if(cashierService.isCashier(id)){
            cashierService.deleteCashier(id);
            return ResponseEntity.status(202).body("Cashier was deleted");
        }
        else
            return ResponseEntity.status(400).body("Cashier not found");

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
