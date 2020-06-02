package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> search() {
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    @ResponseBody
    public Customer save(@RequestBody Customer customerToSave) {
        return customerRepository.save(customerToSave);
    }
}
