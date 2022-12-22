package Puroje.service;

import Puroje.entity.Customer;
import Puroje.repository.CustomerRepository;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public Iterable<Customer> findAll() {
        
        return customerRepository.findAll();     
    }
    
    @Override
    public Customer save(Customer customer){
        
        return customerRepository.save(customer);
    }
        
    @Override
    public Customer login(String name, String pass){
        Customer cus = new Customer();
        Iterable<Customer> listI = customerRepository.findAll();
        Iterator<Customer> list = listI.iterator();
        while(list.hasNext()){
        
            cus = list.next();    
        System.out.println(cus.getFullname() + " - " + cus.getPassword());
            if(cus.getFullname().equals(name) && cus.getPassword().equals(pass))
                return cus;
        }
        
        return null;
    }
}
