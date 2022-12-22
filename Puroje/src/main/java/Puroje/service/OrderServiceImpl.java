package Puroje.service;

import Puroje.entity.Order;
import Puroje.entity.Orderdetail;
import Puroje.entity.Vegetable;
import Puroje.repository.OrderRepository;
import Puroje.repository.OrderdetailRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
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
    
    @Override
    public Iterable<Orderdetail> findOrderdetailOnMonth(){
        
        Iterable<Order> olist = orderRepository.findAll();
        
        List<Order> olist2 = new ArrayList<>(Streamable.of(olist).toList());
        List listID = new ArrayList();
        
        for(int i=0;i<olist2.size();i++){
            Order ord = olist2.get(i);
            System.out.println(ord.getDate().toString().split(" ")[0]);
            if(java.time.LocalDate.now().withMonth(java.time.LocalDate.now()
                    .getMonthValue()-1).isBefore(java.time.LocalDate.parse(ord.getDate().toString().split(" ")[0])))
            {
                listID.add(ord.getOrderID());
            }
        }
        listID.add(1);
        Iterable<Orderdetail> od = orderdetailRepository.findAllById(listID);
        return od;
    }
}
