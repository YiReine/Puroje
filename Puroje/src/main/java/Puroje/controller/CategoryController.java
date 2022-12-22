package Puroje.controller;

import Puroje.entity.Category;
import Puroje.entity.Vegetable;
import Puroje.service.CategoryService;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/cate")
    public @ResponseBody Iterable<Category> index(Model m)
    {
        return  categoryService.findAll();
    }
    @GetMapping("/category")
    public String getByCate(Model m, @ModelAttribute("id") int id)
    {
        Iterable<Vegetable> list = categoryService.findByCate(id);
        Iterable<Category> catelist = categoryService.findAll();
        
                
        m.addAttribute("products", list);
        m.addAttribute("cates", catelist);
        
        return "product";   
    }
}
