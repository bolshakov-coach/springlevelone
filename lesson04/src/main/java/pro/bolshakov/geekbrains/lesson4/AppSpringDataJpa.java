package pro.bolshakov.geekbrains.lesson4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pro.bolshakov.geekbrains.lesson4.config.SpringDataConfig;
import pro.bolshakov.geekbrains.lesson4.repository.ArticleJpaDAO;

import java.util.Arrays;

public class AppSpringDataJpa {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);

        ArticleJpaDAO articleJpaDAO = context.getBean(ArticleJpaDAO.class);

        InitData.initArticlesData();
        articleJpaDAO.saveAll(
                Arrays.asList(InitData.getArticle1(),
                        InitData.getArticle2(),
                        InitData.getArticle3(),
                        InitData.getArticle4())
        );


        System.out.println("FIND ALL");
        articleJpaDAO.findAll().forEach(System.out::println);

        System.out.println("FIND BY ID");
        articleJpaDAO.findById(2L).ifPresent(System.out::println);

        System.out.println("FIND BY LIKE TITLE");
        articleJpaDAO.findAllByTitleLike("%02%").forEach(System.out::println);

        System.out.println("FIND BY BETWEEN ID");
        articleJpaDAO.findAllByIdBetween(1L, 3L).forEach(System.out::println);;


    }
}
