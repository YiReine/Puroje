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
}
