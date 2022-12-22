package Puroje.service;

import Puroje.entity.Order;
import Puroje.entity.Orderdetail;
import Puroje.entity.Vegetable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    @Autowired
    Iterable<Order> findAll();
    Order save(Order order);
    Iterable<Orderdetail> findAllDetail();
    Orderdetail saveDetail(Orderdetail orderdetail);
    Iterable<Orderdetail> findOrderdetailOnMonth();
    Vegetable findVegeById(int id);
}
