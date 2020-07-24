package com.java.controller;

import com.java.model.Customer;
import com.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Method to create a new record in customer document
     * @param customer
     */
    @PostMapping(value = "/")
    public void create(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    /**
     * Method to get all customers details from document
     */
    @GetMapping(value = "/", produces = "application/json")
    public List<Customer> getAll(){
        return customerService.getAllCustomer();
    }

    /**
     * Method to update a record in customer document
     * @param customer
     */
    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public void update(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    /**
     * Method to get record from customer document
     * @param customer
     */
    @GetMapping(value = "/{customernumber}")
    public Optional<Customer> get(@PathVariable int customernumber){
        return customerService.findCustomerById(customernumber);
    }

    /**
     * Method to delete a record in customer document
     * @param customer
     */
    @DeleteMapping(value ="/{customernumber}", produces = "application/json")
    public void delete(@PathVariable int customernumber) {
        customerService.deleteCustomerById(customernumber);
    }

}
