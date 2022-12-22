package Puroje.controller;

import Puroje.entity.Order;
import Puroje.entity.Orderdetail;
import Puroje.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/order")
    public @ResponseBody Iterable<Order> getAll(Model m)
    {
        return  orderService.findAll();
    }
    
    @GetMapping("/orderdetail")
    public @ResponseBody Iterable<Orderdetail> getAllDetail(Model m)
    {
        return  orderService.findAllDetail();
    }
    
    @GetMapping("/cart")
    public String getAl(Model m){
        
        return "cart";   
    }  
    @GetMapping("/cart1")
    public String getB(Model m)
    {
        
        return "cart-empty";   
    } 
    @GetMapping("/checkout")
    public String getA(Model m)
    {
        
        return "checkout";   
    }  
}
