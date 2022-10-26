package com.example.Fotocopy.repo;

import com.example.Fotocopy.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository <Customers, Long> {
}
