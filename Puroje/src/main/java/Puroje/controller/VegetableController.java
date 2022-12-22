package Puroje.controller;

import Puroje.entity.Category;
import Puroje.entity.Vegetable;
import Puroje.service.VegetableService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;
    
    @GetMapping("/index")
    public @ResponseBody Iterable<Vegetable> index(Model m)
    {
        return  vegetableService.findAll();
    }
    @GetMapping("/ca")
    public @ResponseBody Iterable<Category> cate(Model m)
    {
        return  vegetableService.findCate();
    }
    @GetMapping("/all")
    public String getAll(Model m)
    {
        Iterable<Vegetable> list = vegetableService.findAll();
        Iterable<Category> catelist = vegetableService.findCate();
        
        
        //Optional<Category> cate = vegtableService.findCateById();
        m.addAttribute("products", list);
        m.addAttribute("cates", catelist);
        
        return "product";   
    } 
    @GetMapping("/trend")
    public String getTrend(Model m)
    {
        
        Iterable<Vegetable> list = vegetableService.sort("trend");
        
        m.addAttribute("products", list);
        
        return "product";
    }
    @GetMapping("/cheap")
    public String getCheap(Model m)
    {
        
        Iterable<Vegetable> list = vegetableService.sort("cheap");
        
        m.addAttribute("products", list);
        
        return "product";
    }  
}
