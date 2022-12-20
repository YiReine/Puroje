package Puroje.service;

import Puroje.entity.Order;
import Puroje.entity.Orderdetail;
import Puroje.repository.OrderRepository;
import Puroje.repository.OrderdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    private OrderdetailRepository orderdetailRepository;
    
    @Override
    public Iterable<Order> findAll() {
        
        return orderRepository.findAll();     
    }
    
    @Override
    public Order save(Order order){
        
        return orderRepository.save(order);
    }
    @Override
    
    public Iterable<Orderdetail> findAllDetail() {
        
        return orderdetailRepository.findAll();     
    }
    
    @Override
    public Orderdetail saveDetail(Orderdetail orderdetail){
        
        return orderdetailRepository.save(orderdetail);
    }
}
