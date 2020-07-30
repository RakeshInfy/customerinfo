package com.java.controller;

import com.java.model.Customer;
import com.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Method to create a new record in customer document
     * @param customer
     */
    @PostMapping(value = "/")
    public Customer create(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    /**
     * Method to get all customers details from document
     */
    @Cacheable(value = "customers" , key="customernumber")
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
     * @param customernumber
     */
    @Cacheable(value = "customer", key="customernumber")
    @GetMapping(value = "/{customernumber}")
    public ResponseEntity<Customer> get(@PathVariable(value = "customernumber")int customernumber){
       Optional<Customer> customer = customerService.findCustomerById(customernumber);
       if (customer.isPresent() ) {
          return customer.get().getStatus().booleanValue() == false ?
           new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<Customer>(customer.get(),HttpStatus.OK);
       }
        return null;

    }

    /**
     * Method to delete a record in customer document
     * @param customernumber
     */
    @CacheEvict(value = "customers", allEntries=true)
    @DeleteMapping(value ="/{customernumber}", produces = "application/json")
    public void delete(@PathVariable(value = "customernumber") int customernumber) {
        customerService.deleteCustomerById(customernumber);
    }

}
