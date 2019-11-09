package com.sg.customerinfo.repository;

import com.sg.customerinfo.model.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

    DeliveryAddress findDeliveryAddressById(int id);
}
