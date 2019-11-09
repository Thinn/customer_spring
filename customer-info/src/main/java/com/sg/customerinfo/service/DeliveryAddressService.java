package com.sg.customerinfo.service;

import com.sg.customerinfo.model.Customer;
import com.sg.customerinfo.model.DeliveryAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeliveryAddressService {
    Customer insertDeliveryAddressByCustomerId(DeliveryAddress deliveryAddress,Customer customer);
    DeliveryAddress updateDeliveryAddressById(DeliveryAddress deliveryAddress);
    void deleteDeliveryAddressById(DeliveryAddress deliveryAddress);
    List<DeliveryAddress> findAllDeliveryAddresses();
    List<DeliveryAddress> findDeliveryAddressByCustomerId(int customerId);

}
