package com.day2.assignment2a;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    ArrayList<Customer> myDB = new ArrayList<Customer>();

    @GetMapping("/getAll")
    public ArrayList<Customer> getCustomers(){
        return myDB;
    }

    @PostMapping("/addCustomer")
    public Response addCustomer(@RequestBody Customer customer)
    {
        myDB.add(customer);
        return new Response(" the user was created successfully");
    }
    @GetMapping("/getCustomer")
    public Response getCustomer(@RequestBody int ID){
        Customer tempCustomer = null;
        for ( int i = 0 ; i < myDB.size();i++){
            if (myDB.get(i).getID() == ID) //to resolve spaces in the inputs
                tempCustomer = myDB.get(i);
                break;
        }
        return new Response(tempCustomer.toString());
    }
    @DeleteMapping("/delete/{index}")
    public Response deleteCustomer(@PathVariable int i){
        String tempName = myDB.get(i).getUsername();
        myDB.remove(i);
        return  new Response(tempName + " was deleted successfully");
    }
    @PutMapping("/withdraw/{index}/{cash}")
    public Response withdraw(@PathVariable int index, @PathVariable double cash) {

        int permaLink = 0;
        Customer tempCustomer = new Customer(-1,-1,"Default Null Value");
        for ( int i = 0 ; i < myDB.size();i++){
            if (myDB.get(i).getID() == index ) {
                tempCustomer = myDB.get(i);
                permaLink = i;
            }
            break;
        }

        if(myDB.get(permaLink).getBalance()<cash)
            return new Response("You don't have enough balance or you entered a wrong ID");

        else {
            myDB.get(permaLink).setBalance(tempCustomer.getBalance() - cash);

            return new Response("Customer was updated successfully");
        }


    }


    @PutMapping("/deposit/{index}/{cash}")
    public Response deposit(@PathVariable int index, @PathVariable double cash) {
        int permaLink = 0;
        Customer tempCustomer = new Customer(-1, -1, "Default Null Value");
        for (int i = 0; i < myDB.size(); i++) {
            if (myDB.get(i).getID() == index) {
                tempCustomer = myDB.get(i);
                permaLink = i;
            }
            break;
        }
        if (cash < 0)
            return new Response("deposit amount can't be negative");

        else {
            myDB.get(permaLink).setBalance(tempCustomer.getBalance() + cash);

            return new Response("You deposited " + cash + " SAR, your new balance is (" + myDB.get(permaLink).getBalance()+")");
        }

    }
}
