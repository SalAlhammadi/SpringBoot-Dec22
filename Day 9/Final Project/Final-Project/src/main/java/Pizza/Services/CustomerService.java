package Pizza.Services;

import Pizza.Models.User.Customer;
import Pizza.Repos.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;




@Service

@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customers;

    public List<Customer> getAll(){
        return customers.findAll();
    }
    public void addCustomer(Customer customer){
        customers.save(customer);

    }
    public boolean isCustomer(Integer id){
        List<Customer> currentCustomers = customers.findAll();
        for (Customer customer: currentCustomers) {
            if (customer.getId()==(id))
                return true;
        }
        return false;
    }
    public void deleteCustomer(Integer id){
        customers.findAll().remove(id);
    }

    public void updateCustomer(Integer id, Customer customer){
        customers.findAll().set(id,customer);
    }
}
