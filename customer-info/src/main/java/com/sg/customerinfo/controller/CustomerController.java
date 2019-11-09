package com.sg.customerinfo.controller;

import com.sg.customerinfo.model.Customer;
import com.sg.customerinfo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.sg.customerinfo.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping("/customer")
    public Customer insertNewCustomer(@RequestBody Customer customer) {
        return customerService.insertCustomer(customer);
    }

}
