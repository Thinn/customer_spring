package com.sg.customerinfo.model;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String name;

    @OneToMany(cascade=CascadeType.REMOVE, orphanRemoval=true,fetch=FetchType.EAGER, mappedBy="customer")
    private List<DeliveryAddress> addresses = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeliveryAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<DeliveryAddress> addresses) {
        this.addresses = addresses;
    }
}
