package Pizza.Repos;

import Pizza.Models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
    @Query("SELECT p.price FROM Pizza p where p.id = :id")
    double findPriceById(@Param("id") Integer id);

    @Query("SELECT p.quantity FROM Pizza p where p.id = :id")
    int findQuantityById(@Param("id") Integer id);

}
