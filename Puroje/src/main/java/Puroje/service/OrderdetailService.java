/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
