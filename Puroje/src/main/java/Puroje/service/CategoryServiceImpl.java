package Puroje.service;

import Puroje.entity.Category;
import Puroje.entity.Vegetable;
import Puroje.repository.CategoryRepository;
import Puroje.repository.VegetableRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private VegetableRepository vegetableRepository;
    
    @Override
    public Iterable<Category> findAll() {
        
        return categoryRepository.findAll();     
    }
    
    @Override
    public Optional<Category> findById(int id) {
        
        return categoryRepository.findById(id);     
    }
    @Override
    public Iterable<Vegetable> findByCate(int cate) {
        
        Iterable<Vegetable> list = vegetableRepository.findAll();
        List<Vegetable> list2 = new ArrayList<Vegetable>(Streamable.of(list).toList());
        
        for(int i=0;i<list2.size();i++){
            Vegetable vege = list2.get(i);
            if(vege.getCatagoryID() != cate){
                list2.remove(i);
                i--;
            }
        }
        
        return list2;   
    }
    
}
