/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.controller;

import Puroje.entity.Order;
import Puroje.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @GetMapping("/order")
    public @ResponseBody Iterable<Order> index(Model m)
    {
        return  orderRepository.findAll();
    }
}
