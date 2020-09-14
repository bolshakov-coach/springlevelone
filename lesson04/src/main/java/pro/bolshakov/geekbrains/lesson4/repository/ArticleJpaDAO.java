package pro.bolshakov.geekbrains.lesson4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.bolshakov.geekbrains.lesson4.domain.Article;

import java.util.List;

public interface ArticleJpaDAO extends JpaRepository<Article, Long> {
    List<Article> findAllByTitleLike(String title);
    List<Article> findAllByIdBetween(Long startId, Long endId);
}
