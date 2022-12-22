package Puroje.service;

import Puroje.entity.Category;
import Puroje.entity.Vegetable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface VegetableService {
    @Autowired
    Iterable<Vegetable> findAll();
    Iterable<Vegetable> findByPrice(String price);
    List<Vegetable> search(String term);
    Optional<Category> findCateById(int id);
    Iterable<Category> findCate();
    Iterable<Vegetable> sort(String s);
}
