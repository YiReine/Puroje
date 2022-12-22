/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.service;

import Puroje.entity.Category;
import Puroje.entity.Vegetable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    @Autowired
    Iterable<Category> findAll();
    Optional<Category> findById(int id);
    Iterable<Vegetable> findByCate(int cate);
}
