package Puroje.service;

import Puroje.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    @Autowired
    Iterable<Customer> findAll();
    Customer save(Customer customer);
    Customer login(String name, String pass);
}
