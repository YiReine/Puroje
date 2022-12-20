/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.service;

import Puroje.entity.Vegetable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface VegetableService {
    @Autowired
    Iterable<Vegetable> findAll();
    List<Vegetable> search(String term);
}
