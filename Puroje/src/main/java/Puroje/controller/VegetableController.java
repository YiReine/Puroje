package Puroje.controller;

import Puroje.entity.Category;
import Puroje.entity.Vegetable;
import Puroje.service.VegetableService;
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
        Iterable<Category> catelist = vegetableService.findCate();
        
        m.addAttribute("products", list);
        m.addAttribute("cates", catelist);
        
        return "product";
    }
    @GetMapping("/cheap")
    public String getCheap(Model m)
    {
        
        Iterable<Vegetable> list = vegetableService.sort("cheap");
        Iterable<Category> catelist = vegetableService.findCate();
        
        m.addAttribute("products", list);
        m.addAttribute("cates", catelist);
        
        return "product";
    }  
    
    @GetMapping("/price")
    public String getPrice(Model m, @ModelAttribute("min") int min, @ModelAttribute("max") int max)
    {
        
        Iterable<Vegetable> list = vegetableService.findByPrice(min,max);
        Iterable<Category> catelist = vegetableService.findCate();
        
        m.addAttribute("products", list);
        m.addAttribute("cates", catelist);
        
        return "product";
    } 
    
    @GetMapping("/search")
    public String getSearch(Model m, @ModelAttribute("name") String name)
    {
        
        Iterable<Vegetable> list = vegetableService.findByName(name);
        Iterable<Category> catelist = vegetableService.findCate();
        
        m.addAttribute("products", list);
        m.addAttribute("cates", catelist);
        
        return "product";
    } 
    
    @GetMapping("/category")
    public String getByCate(Model m, @ModelAttribute("id") int id)
    {
        Iterable<Vegetable> list = vegetableService.findByCate(id);
        Iterable<Category> catelist = vegetableService.findCate();
        
                
        m.addAttribute("products", list);
        m.addAttribute("cates", catelist);
        
        return "product";   
    }
}
