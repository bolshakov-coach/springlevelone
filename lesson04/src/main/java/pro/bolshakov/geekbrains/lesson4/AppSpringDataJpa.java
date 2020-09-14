package pro.bolshakov.geekbrains.lesson4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pro.bolshakov.geekbrains.lesson4.config.SpringDataConfig;
import pro.bolshakov.geekbrains.lesson4.domain.Article;
import pro.bolshakov.geekbrains.lesson4.domain.Author;
import pro.bolshakov.geekbrains.lesson4.domain.Category;
import pro.bolshakov.geekbrains.lesson4.repository.ArticleJpaDAO;
import pro.bolshakov.geekbrains.lesson4.service.ArticleServiceImpl;

import java.util.Arrays;

public class AppSpringDataJpa {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);

        ArticleServiceImpl articleService = context.getBean(ArticleServiceImpl.class);

        Article article = InitData.getArticle1();
        System.out.println(article);
        Category category = InitData.getCategory1();
        Author author = InitData.getAuthor1();

        articleService.saveAndSet(article, author, category);

        System.out.println(articleService.findById(3L));


    }
}
