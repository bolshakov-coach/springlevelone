package pro.bolshakov.geekbrains.lesson4;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AppArticles {

    public static void main(String[] args) {

        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();

        InitData.initData(em);




    }
}
