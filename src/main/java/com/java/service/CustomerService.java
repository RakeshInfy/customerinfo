package com.java.service;

import com.java.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public void createCustomer(Customer customer);
    public List<Customer> getAllCustomer();
    public Optional<Customer> findCustomerById(int customerNumber) ;
    public void deleteCustomerById(int customerNumber) ;
    public void updateCustomer(Customer customer) ;

}
