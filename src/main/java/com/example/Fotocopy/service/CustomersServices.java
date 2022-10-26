package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Customers;

import java.util.List;

public interface CustomersServices {
    Customers getCustomersId(Long idCustomer);
    List<Customers> getAllCustomers();
    Customers saveCustomers(Customers customers);
    void updateCustomers(Long idCustomer, Customers customers);
    void deleteCustomers(Long idCustomer);
}
