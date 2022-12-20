/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.controller;

import Puroje.entity.Customer;
import Puroje.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customer")
    public @ResponseBody Iterable<Customer> index(Model m)
    {
        return  customerService.findAll();
    }
    
    @GetMapping("/login")
    public String login(Model m)
    {
        
        Customer cus = new Customer();
        m.addAttribute("customer", cus);
        return "login";
        
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session, Model m)
    {
        session.setAttribute("user", null);
        return "home";
        
    }
    
    @RequestMapping("/login")
    public String doLogin(ModelMap mm, HttpSession session, @ModelAttribute("customer") Customer customer) {
          
          Customer cus = customerService.login(customer.getFullname(), customer.getPassword());
          if (cus == null) {
              System.out.println(customer.getFullname() + " - " + customer.getPassword());
               mm.put("customer", new Customer());
               mm.put("msg", "The username or password is incorrect!");
               return "login";
          }
          session.setAttribute("user", cus);
          return "redirect:/home";
    }
    
    @GetMapping("/register")
    public String register(Model m)
    {
        Customer cus = new Customer();
        m.addAttribute("customer", cus);
        return "register";
        
    }
    @PostMapping("/customer/save")
    public String save(Model model, @ModelAttribute("customer") Customer customer)
    {
        
        customerService.save(customer);
        
        return "redirect:../";
        
    }
}
