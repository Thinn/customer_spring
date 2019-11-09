package com.sg.customerinfo.service.impl;
import com.sg.customerinfo.model.Customer;
import com.sg.customerinfo.model.DeliveryAddress;
import com.sg.customerinfo.repository.CustomerRepository;
import com.sg.customerinfo.repository.DeliveryAddressRepository;
import com.sg.customerinfo.service.CustomerService;
import com.sg.customerinfo.service.DeliveryAddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService{
    final static Logger logger = Logger.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;
    @Autowired
    private CustomerService customerService;

    @Override
    public Customer insertDeliveryAddressByCustomerId(DeliveryAddress deliveryAddress, Customer customer) {
        logger.info("Insert Delivery Address By CustomerId:: ");
        Customer cus=null;
        //If customer doesn't exit, create new Customer
        if(customer==null  || customer.getId()== 0){
            logger.info("Insert new Customer:: ");
            cus=customerService.insertCustomer(customer);
        }else{
            logger.info("Find Customer By Id:: ");
            cus=customerService.findCustomerById(customer.getId());
        }
        if(cus!=null){
            logger.info("Save Delivery:: ");
            deliveryAddress.setCustomer(cus);
            DeliveryAddress result_add=deliveryAddressRepository.saveAndFlush(deliveryAddress);
        }else{
            logger.error("Customer cannot be found:: ");
        }

        return cus;
    }

    @Override
    public DeliveryAddress updateDeliveryAddressById(DeliveryAddress deliveryAddress) {
        logger.info("Update Delivery Address By Id:: ");
        DeliveryAddress result=null;
        if(!(deliveryAddress == null ||deliveryAddress.getId()==0 )){
            logger.info("Find Delivery Address By Id:: ");
            result =   deliveryAddressRepository.findDeliveryAddressById(deliveryAddress.getId());
        }
        if(result!=null){
            logger.info("Save Delivery Address:: ");
            deliveryAddress.setCustomer(result.getCustomer());
            return deliveryAddressRepository.save(deliveryAddress);
        }
        else{
            logger.error("Delivery Address cannot be found:: ");
            return null;
        }
    }

    @Override
    public void deleteDeliveryAddressById(DeliveryAddress deliveryAddress) {
        logger.info("delete Delivery Address By Id:: ");
        DeliveryAddress result=null;
        if(!(deliveryAddress == null ||deliveryAddress.getId()==0 )){
            logger.info("Find Delivery Address By Id:: ");
            result =   deliveryAddressRepository.findDeliveryAddressById(deliveryAddress.getId());
        }
        if(result!=null){
            logger.info("Delete Delivery Address:: ");
            deliveryAddressRepository.delete(deliveryAddress);
        }else{
            logger.error("Delivery Address cannot be found:: ");
        }

    }

    @Override
    public List<DeliveryAddress> findAllDeliveryAddresses() {
        logger.info("Find all delivery addresses:: ");
        return deliveryAddressRepository.findAll();
    }

    @Override
    public List<DeliveryAddress> findDeliveryAddressByCustomerId(int customerId) {
        logger.info("Find delivery addresses by customer Id:: ");
        Customer cus=customerService.findCustomerById(customerId);
        if(cus!=null){
            return cus.getAddresses();
        }
        else{
            logger.error("Customer cannot be found:: ");
            return new ArrayList<>();
        }
    }

}
