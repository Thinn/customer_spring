package com.sg.customerinfo;

import com.oracle.tools.packager.Log;
import com.sg.customerinfo.model.Customer;
import com.sg.customerinfo.model.DeliveryAddress;
import com.sg.customerinfo.repository.CustomerRepository;
import com.sg.customerinfo.service.CustomerService;
import com.sg.customerinfo.service.DeliveryAddressService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerInfoApplicationTests {
	final static Logger logger = Logger.getLogger(CustomerInfoApplicationTests.class);

	@Autowired
	private CustomerService customerService;

    @Autowired
    private DeliveryAddressService deliveryAddressService;


	@Test
	public void testInsertCustomer() {

		String firstName="Allex1";
		String lastName="Ohm1";

		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setName(firstName+lastName);
		Customer result1=customerService.insertCustomer(customer);

        DeliveryAddress add1= new DeliveryAddress();
        add1.setAddress1("Blk 513");
        add1.setAddress2("Blk 512");
        add1.setPostalCode("120513");
        add1.setState("SG");
        add1.setCity("SG");
        deliveryAddressService.insertDeliveryAddressByCustomerId(add1,result1);

	}

     @Test
    public void testUpdateCustomer() {
        String firstName="Hlaing";
        String lastName="Thinn";
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setName(firstName+lastName);
        customerService.updateCustomer(customer);
    }

   @Test
    public void testdeleteCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customerService.deleteCustomer(customer);
    }


    @Test
	public void testInsertAddressByCustomer(){
        String firstName="Thinn";
        String lastName="Thinn";

        Customer customer= new Customer();
	    customer.setId(1);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setName(firstName+lastName);
        DeliveryAddress add1= new DeliveryAddress();
        add1.setAddress1("Blk 789");
        add1.setPostalCode("126518");
        add1.setState("SG");
        add1.setCity("SG");
        deliveryAddressService.insertDeliveryAddressByCustomerId(add1,customer);
    }

    @Test
    public void testupdateAddressById(){
        DeliveryAddress add1= new DeliveryAddress();
        add1.setId(4);
        add1.setAddress1("Blk 789");
        add1.setAddress2("Clementi");
        add1.setPostalCode("126518");
        add1.setState("SG");
        add1.setCity("Singapore");
        add1.setCountry("SG");
        deliveryAddressService.updateDeliveryAddressById(add1);
    }


   @Test
    public void testDeleteAddressById(){
        DeliveryAddress add1= new DeliveryAddress();
        add1.setId(2);
        deliveryAddressService.deleteDeliveryAddressById(add1);
    }

    @Test
    public void testSelectAllCustomers(){

       List<Customer> customers=customerService.findAllCustomers();
       for(Customer c: customers){
           logger.info("Customer Name::"+ c.getName());
           List<DeliveryAddress> addresses=c.getAddresses();

           for(DeliveryAddress d: addresses){
               logger.info("Customer Address1::"+ d.getAddress1());
           }
           logger.info("-----------------------------");

       }

    }

    @Test
    public void testSelectCustomerById(){

        Customer customer=customerService.findCustomerById(2);
            logger.info("Customer Name::"+ customer.getName());
            List<DeliveryAddress> addresses=customer.getAddresses();

            for(DeliveryAddress d: addresses){
                logger.info("Customer Address1::"+ d.getAddress1());
            }
            logger.info("-----------------------------");
    }

    @Test
    public void testSelectAllDeliveryAddresses(){

        List<DeliveryAddress> addresses=deliveryAddressService.findAllDeliveryAddresses();
        for(DeliveryAddress d: addresses){
            Customer c= d.getCustomer();
            logger.info("Customer ::"+ c.getName());
            logger.info("Address 1::"+ d.getAddress1());
            logger.info("Address 2::"+ d.getAddress2());

            logger.info("-----------------------------");
        }
    }

   @Test
    public void testSelectAddressByCustomer(){

        List<DeliveryAddress> addresses=deliveryAddressService.findDeliveryAddressByCustomerId(2);
        for(DeliveryAddress d: addresses){
            logger.info("Customer Name::"+ d.getAddress1());

                logger.info("Customer Address1::"+ d.getAddress1());
            }
            logger.info("-----------------------------");

        }


}
