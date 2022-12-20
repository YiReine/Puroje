/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.controller;

import Puroje.entity.Vegetable;
import Puroje.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
public class VegetableController {

    @Autowired
    private VegetableService vegtableService;
    
    @GetMapping("/index")
    public @ResponseBody Iterable<Vegetable> index(Model m)
    {
        return  vegtableService.findAll();
    }
    @GetMapping("/all")
    public String getAll(Model m)
    {
        Iterable<Vegetable> list = vegtableService.findAll();
        m.addAttribute("data", list);
        return "product";   
    }    
}
