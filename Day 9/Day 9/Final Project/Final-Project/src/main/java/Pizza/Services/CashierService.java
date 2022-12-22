package Pizza.Services;

import Pizza.Models.User.Cashier;
import Pizza.Repos.CashierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashierService {
    private final CashierRepo cashiers;

    public void addCashier(Cashier Cashier){
        cashiers.save(Cashier);

    }
    public List<Cashier> getAll(){
        return cashiers.findAll();

    }
    public boolean isCashier(Integer id){
        List<Cashier> currentCashiers = cashiers.findAll();
        for (Cashier cashier: currentCashiers) {
            if (cashier.getId()==(id))
                return true;
        }
        return false;
    }
    public void deleteCashier(Integer id){
        cashiers.findAll().remove(id);
    }

    public void updateCashier(Integer id, Cashier cashier){
        cashiers.findAll().set(id,cashier);
    }


}
