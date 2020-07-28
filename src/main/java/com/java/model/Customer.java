package com.java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {

    public Customer(int id, int customerNumber, String name) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.name = name;
    }

    @Id
    private int id;
    private int customerNumber;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerNumber=" + customerNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
