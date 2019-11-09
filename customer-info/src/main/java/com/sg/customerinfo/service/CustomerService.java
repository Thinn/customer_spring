package com.sg.customerinfo.service;

import com.sg.customerinfo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer insertCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Customer findCustomerById(int id);


}
