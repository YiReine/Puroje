package Puroje.service;

import Puroje.entity.Orderdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public interface OrderdetailService {
    @Autowired
    Iterable<Orderdetail> findAll();
    Orderdetail save(Orderdetail orderdetail);
}
