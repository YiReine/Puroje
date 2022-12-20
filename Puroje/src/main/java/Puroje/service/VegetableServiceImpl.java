/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.service;

import Puroje.entity.Vegetable;
import Puroje.repository.VegetableRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VegetableServiceImpl implements VegetableService {

    @Autowired
    private VegetableRepository vegtableRepository;
    @Override
    public Iterable<Vegetable> findAll() {
        
        return vegtableRepository.findAll();     
    }

    @Override
    public List<Vegetable> search(String term) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
