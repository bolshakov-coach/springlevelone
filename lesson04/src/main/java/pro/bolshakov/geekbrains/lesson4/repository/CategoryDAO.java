package pro.bolshakov.geekbrains.lesson4.repository;

import pro.bolshakov.geekbrains.lesson4.domain.Author;
import pro.bolshakov.geekbrains.lesson4.domain.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category author);
    void update(Category author);
    void delete(Category author);
}
