package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Customers;
import com.example.Fotocopy.repo.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceCustomerImpl implements CustomersServices{

    @Autowired
    CustomersRepository customersRepository;

    @Override
    public Customers getCustomersId(Long idCustomer) {
        return customersRepository.findById(idCustomer).get();
    }

    @Override
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Customers saveCustomers(Customers customers) {
        return customersRepository.save(customers);
    }

    @Override
    public void updateCustomers(Long idCustomer, Customers customers) {
        Customers customers1 = customersRepository.findById(idCustomer).get();
        customers1.setFullname(customers.getFullname());
        customers1.setHobby(customers.getHobby());
        customers1.setGender(customers.getGender());
        customers1.setTelp(customers.getTelp());
        customers1.setAddress(customers.getAddress());
        customersRepository.save(customers1);
    }

    @Override
    public void deleteCustomers(Long idCustomer) {
        customersRepository.deleteById(idCustomer);
    }
}
