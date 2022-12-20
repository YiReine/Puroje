package Puroje.service;

import Puroje.entity.Orderdetail;
import Puroje.repository.OrderdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderdetailServiceImpl implements OrderdetailService{
    @Autowired
    private OrderdetailRepository orderdetailRepository;
    
    @Override
    public Iterable<Orderdetail> findAll() {
        
        return orderdetailRepository.findAll();     
    }
    
    @Override
    public Orderdetail save(Orderdetail orderdetail){
        
        return orderdetailRepository.save(orderdetail);
    }
}
