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
    
}
