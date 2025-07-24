package org.example.service;

import jakarta.persistence.metamodel.SingularAttribute;
import org.example.dto.Customer;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAll();

    void deleteCustomer(Integer id);

    void updateCustomer(Customer customer);

    Customer searchById(Integer id);

    List<Customer> searchByName(String name);
}
