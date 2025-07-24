package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.Entity.CustomerEntity;
import org.example.Repository.CustomerRepository;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    final ModelMapper mapper;

    @Override
    public void addCustomer(Customer customer){
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public List <Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> all = repository.findAll();

        all.forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));
        });

        return customerList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
         repository.save(mapper.map(customer,CustomerEntity.class));
    }

    @Override
    public Customer searchById(Integer id) {
        return mapper.map(repository.findById(id) ,Customer.class);

    }

    @Override
    public List<Customer> searchByName(String name) {
        List<CustomerEntity> byName = repository.findByName(name);
        List<Customer> customerList = new ArrayList<>();

        byName.forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));
        });
        return customerList;
    }
}
