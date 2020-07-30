package com.java.customerinfo;

import com.java.model.Customer;
import com.java.repository.CustomerDao;
import com.java.service.CustomerService;
import com.java.service.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerDao customerDao;

    @Before
    public void setUp() {

    }

    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {

        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }


    @Test
    public void whenValidCustomerId_ThenCustomerShouldBeFound() {
        Customer customer = new Customer(1211,1111, "Rakesh", true);
        Mockito.when(customerDao.findById(1211)).thenReturn(java.util.Optional.of(customer));
        Optional<Customer> custSearched = customerService.findCustomerById(1211);
        Assert.assertTrue(custSearched.get().getName().equals(customer.getName()));
    }

    @Test
    public void testForFetchingAllRecords() {
        Customer customer1 = new Customer(1211,1111, "Rakesh", true);
        Customer customer2 = new Customer(1212,1112, "Ram", true);
        List<Customer> customers = Arrays.asList(customer1, customer2);
        Mockito.when(customerDao.findAll()).thenReturn(customers);
        List<Customer> allCustomers = customerService.getAllCustomer();
        Assert.assertTrue(allCustomers.size() == 2);
    }

}
