package pro.bolshakov.geekbrains.lesson4.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.bolshakov.geekbrains.lesson4.domain.Article;
import pro.bolshakov.geekbrains.lesson4.domain.Author;
import pro.bolshakov.geekbrains.lesson4.domain.Category;
import pro.bolshakov.geekbrains.lesson4.repository.ArticleJpaDAO;
import pro.bolshakov.geekbrains.lesson4.repository.AuthorJpaDAO;
import pro.bolshakov.geekbrains.lesson4.repository.CategoryJpaDAO;


@Service
public class ArticleServiceImpl {

    private final ArticleJpaDAO articleJpaDAO;
    private final AuthorJpaDAO authorJpaDAO;
    private final CategoryJpaDAO categoryJpaDAO;

    public ArticleServiceImpl(ArticleJpaDAO articleJpaDAO, AuthorJpaDAO authorJpaDAO, CategoryJpaDAO categoryJpaDAO) {
        this.articleJpaDAO = articleJpaDAO;
        this.authorJpaDAO = authorJpaDAO;
        this.categoryJpaDAO = categoryJpaDAO;
    }

    @Transactional
    public void saveAndSet(Article article, Author author, Category category){
        Author savedAuthor = authorJpaDAO.save(author);
        Category savedCategory = categoryJpaDAO.save(category);

        article.setAuthor(savedAuthor);
        article.setCategory(savedCategory);

        articleJpaDAO.save(article);
    }

    @Transactional(readOnly = true)
    public Article findById(Long id){
        return articleJpaDAO.findById(id).orElse(null);
    }

}
