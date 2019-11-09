package com.sg.customerinfo.repository;

import com.sg.customerinfo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
   Customer findCustomerById(int id);

}
