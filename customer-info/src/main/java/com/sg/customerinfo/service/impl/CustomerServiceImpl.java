package com.sg.customerinfo.service.impl;
import com.sg.customerinfo.model.Customer;
import com.sg.customerinfo.repository.CustomerRepository;
import com.sg.customerinfo.repository.DeliveryAddressRepository;
import com.sg.customerinfo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    final static Logger logger = Logger.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;

    @Override
    public Customer insertCustomer(Customer customer) {
        logger.info("Insert Customer:: ");
        if(customer !=null  && customer.getId()== 0){
            logger.info("Create New Customer:: ");
            return customerRepository.saveAndFlush(customer);
        }else{
            logger.error("Exiting Customer:: ");
            return null;
        }

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        logger.info("Update Customer:: ");
        Customer result= null;
        if(customer!=null  && customer.getId()!= 0){
            logger.info("Find Customer By Id:: ");
            result=customerRepository.findCustomerById(customer.getId());
        }

        if(result!=null){
            logger.info("update customer::");
            return customerRepository.save(customer);
        }
        else{
            logger.error("Customer Id is required for updating::");
            return null;
        }

    }

    @Override
    public void deleteCustomer(Customer customer) {
        logger.info("delete Customer By Id:: ");
        Customer cus= customerRepository.findCustomerById(customer.getId());
            if(cus !=null){
                logger.info("Removing Customer:: ");
                customerRepository.delete(customer);
            }else{
                logger.error("Customer cannot be found:: ");
            }

    }

    @Override
    public List<Customer> findAllCustomers() {
        logger.info("find all customers::");
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(int id) {
        logger.info("find customer by customer id::");
        return customerRepository.findCustomerById(id);
    }

}
