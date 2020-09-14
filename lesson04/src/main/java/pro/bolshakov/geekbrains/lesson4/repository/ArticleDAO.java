package pro.bolshakov.geekbrains.lesson4.repository;

import pro.bolshakov.geekbrains.lesson4.domain.Article;
import pro.bolshakov.geekbrains.lesson4.domain.Category;

import java.util.List;

public interface ArticleDAO {
    List<Article> findAll();
    Article findById(Long id);
    void save(Article author);
    void update(Article author);
    void delete(Article author);
}
