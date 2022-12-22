package Pizza.Repos;

import Pizza.Models.User.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierRepo extends JpaRepository<Cashier, Integer> {

}
