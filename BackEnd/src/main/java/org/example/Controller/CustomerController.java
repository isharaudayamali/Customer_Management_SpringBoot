package org.example.Controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    final CustomerService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Customer> getAll(){
        return service.getAll();
    }

    @GetMapping("/searchById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Customer searchById(@PathVariable Integer id){
        return service.searchById(id);
    }

    @GetMapping("/searchByName/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List <Customer> searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        //System.out.println(id);
        service.deleteCustomer(id);
    }
    
    @PutMapping("/update/{id}")
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);
    }
}
