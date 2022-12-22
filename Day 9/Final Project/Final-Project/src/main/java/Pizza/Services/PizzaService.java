package Pizza.Services;

import Pizza.Models.Pizza;
import Pizza.Repos.PizzaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepo pizzas;

    public List<Pizza> getAll() {
        return pizzas.findAll();
    }

    public void addPizza(Pizza pizza) {
        pizzas.save(pizza);

    }

    public boolean isPizza(Integer id) {
        List<Pizza> currentPizza = pizzas.findAll();
        for (Pizza pizza : currentPizza) {
            if (pizza.getId() == (id))
                return true;
        }
        return false;
    }

    public void deletePizza(Integer id) {
        pizzas.findAll().remove(id);
    }

    public void updatePizza(Integer id, Pizza pizza) {
        pizzas.findAll().set(id, pizza);
    }

    public double getPrice(Integer id) {
        return pizzas.findPriceById(id)*pizzas.findQuantityById(id);
    }

}

