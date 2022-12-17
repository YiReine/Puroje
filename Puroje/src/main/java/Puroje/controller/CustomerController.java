/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.controller;

import Puroje.entity.Customer;
import Puroje.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/customer")
    public @ResponseBody Iterable<Customer> index(Model m)
    {
        return  customerRepository.findAll();
    }
}
