package com.example.Fotocopy.api;

import com.example.Fotocopy.model.Category;
import com.example.Fotocopy.model.dto.ResponseMessage;
import com.example.Fotocopy.model.Customers;
import com.example.Fotocopy.service.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomersController {
    @Autowired
    CustomersServices customersServices;

    @GetMapping({"/getCustomers/{idCustomer}"})
    public ResponseEntity<Customers> getCustomersId(@PathVariable Long idCustomer) {
        Customers customers = customersServices.getCustomersId(idCustomer);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customers>> getAllCustomers() {

        List<Customers> customersList = customersServices.getAllCustomers();

        return ResponseEntity.ok(customersList);
    }

    @PostMapping("/getCustomers")
    public ResponseEntity<ResponseMessage> saveCategory(@RequestBody Customers customers) {
        String data = "";
        String message = "";
        try {
            customersServices.saveCustomers(customers);
            message = "Sukses";
            data = "Data berhasil ditambah";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, data));
        } catch (Exception e) {
            message = "gagal";
            data = "Data error";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, data));
        }
    }
    @PutMapping("/getCustomers/{idCustomer}")
    public ResponseEntity<Customers> updateCustomers(@PathVariable("idCustomer") Long idCustomer, @RequestBody Customers customers) {
        customersServices.updateCustomers(idCustomer, customers);
        return new ResponseEntity<>(customersServices.getCustomersId(idCustomer), HttpStatus.OK);
    }

    @DeleteMapping({"/getCustomers/{idCustomer}"})
    public ResponseEntity<Category> deleteCustomers(@PathVariable("idCustomer") Long idCustomer) {
        customersServices.deleteCustomers(idCustomer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
