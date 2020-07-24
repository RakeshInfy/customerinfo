package com.java.service;

import com.java.model.Customer;
import com.java.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void createCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(int customerNumber) {
        return customerDao.findById(customerNumber);
    }

    @Override
    public void deleteCustomerById(int customerNumber) {
        customerDao.deleteById(customerNumber);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.save(customer);
    }
}
