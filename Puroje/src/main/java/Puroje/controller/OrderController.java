package Puroje.controller;

import Puroje.entity.Cart;
import Puroje.entity.Category;
import Puroje.entity.Customer;
import Puroje.entity.Order;
import Puroje.entity.Orderdetail;
import Puroje.entity.Vegetable;
import Puroje.service.OrderService;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String getCart(Model m, HttpSession session){
        HashMap<Integer, Cart> cartList = (HashMap<Integer, Cart>) session.getAttribute("carts");
        if(cartList == null || cartList.isEmpty()){
            return "cart-empty"; 
        }
        
        m.addAttribute("carts", cartList);
        m.addAttribute("carttotal", totalPrice(cartList));
        m.addAttribute("cartnum", cartList.size());
        return "cart";   
    }  
    
    @GetMapping("/add-cart")
    public String addCart(Model m, @ModelAttribute("vegeId") int vegeId, HttpSession session)
    {
        HashMap<Integer, Cart> cartList = (HashMap<Integer, Cart>) session.getAttribute("carts");
        if(cartList == null){
            cartList = new HashMap<>();
        }
        Vegetable vege = orderService.findVegeById(vegeId);
        if(vege != null){
            if(cartList.containsKey(vegeId)){
                Cart cart = cartList.get(vegeId);
                cart.setVegetable(vege);
                cart.setQuantity(cart.getQuantity()+1);
                cartList.put(vegeId, cart);
            }
            else{
                Cart cart = new Cart();
                cart.setVegetable(vege);
                cart.setQuantity(1);
                cartList.put(vegeId, cart);
            }
        }
        session.setAttribute("carts", cartList);
        m.addAttribute("carts", cartList);
        m.addAttribute("carttotal", totalPrice(cartList));
        m.addAttribute("cartnum", cartList.size());
        
        
        return "redirect:/cart";
    } 
    
    @GetMapping("/sub-cart")
    public String subCart(Model m, @ModelAttribute("vegeId") int vegeId, HttpSession session)
    {
        HashMap<Integer, Cart> cartList = (HashMap<Integer, Cart>) session.getAttribute("carts");
        if(cartList == null){
            cartList = new HashMap<>();
        }
        if(cartList.containsKey(vegeId)){
            Cart cart = cartList.get(vegeId);
            cart.setQuantity(cart.getQuantity()-1);

            if(cart.getQuantity() == 0){
                cartList.remove(vegeId);
            }
        }
        
        session.setAttribute("carts", cartList);
        m.addAttribute("carts", cartList);
        m.addAttribute("carttotal", totalPrice(cartList));
        m.addAttribute("cartnum", cartList.size());
        
        return "redirect:/cart";
    }  
    @GetMapping("/remove-cart")
    public String removeCart(Model m, @ModelAttribute("vegeId") int vegeId, HttpSession session)
    {
        HashMap<Integer, Cart> cartList = (HashMap<Integer, Cart>) session.getAttribute("carts");
        if(cartList == null){
            cartList = new HashMap<>();
        }
        if(cartList.containsKey(vegeId)){
            cartList.remove(vegeId);
            
        }
        
        session.setAttribute("carts", cartList);
        m.addAttribute("carts", cartList);
        m.addAttribute("carttotal", totalPrice(cartList));
        m.addAttribute("cartnum", cartList.size());
        
        return "redirect:/cart";
    }
    
    public double totalPrice(HashMap<Integer, Cart> cartList){
        double total=0;
        for(Map.Entry<Integer, Cart> cart:cartList.entrySet()){
            total+= cart.getValue().getVegetable().getPrice()*cart.getValue().getQuantity();
        }
        return total;
    }
    
    @GetMapping("/cart0")
    public String getC(Model m)
    {
        
        return "cart-empty";   
    } 
    @GetMapping("/checkout")
    public String getCheckout(Model m, HttpSession session)
    {
        HashMap<Integer, Cart> cartList = (HashMap<Integer, Cart>) session.getAttribute("carts");
        if(cartList == null || cartList.isEmpty()){
            return "redirect:/"; 
        }
        
        m.addAttribute("carts", cartList);
        m.addAttribute("carttotal", totalPrice(cartList));
        m.addAttribute("cartnum", cartList.size());
        return "checkout";   
    }  
    @GetMapping("/create-checkout")
    public String getCreateCheckout(Model m, HttpSession session) throws ParseException
    {
        HashMap<Integer, Cart> cartList = (HashMap<Integer, Cart>) session.getAttribute("carts");
        if(cartList == null || cartList.isEmpty()){
            return "redirect:/"; 
        }
        Customer cus = (Customer) session.getAttribute("user");
        
        Order order = new Order();
        order.setCustomerID(cus.getCustomerID());
        order.setTotal(totalPrice(cartList));
        order.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString()));
        
        
        Order orderS = orderService.save(order);
        
        Orderdetail orderdetail = new Orderdetail();
        orderdetail.setOrderID(orderS.getOrderID());
        
        for(Map.Entry<Integer, Cart> cart:cartList.entrySet()){
            orderdetail.setPrice(cart.getValue().getVegetable().getPrice());
            orderdetail.setQuantity(cart.getValue().getQuantity());
            orderdetail.setVegetableID(cart.getValue().getVegetable().getVegetableID());
            orderService.saveDetail(orderdetail);
        }
        session.setAttribute("carts", null);
        
        return "redirect:/";   
    }
    
}
