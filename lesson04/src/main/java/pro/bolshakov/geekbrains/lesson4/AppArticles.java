package pro.bolshakov.geekbrains.lesson4;

import org.hibernate.cfg.Configuration;
import pro.bolshakov.geekbrains.lesson4.domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppArticles {

    public static void main(String[] args) {

        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();

        InitData.initData(em);

        examplePersistenceArea(em);
    }

    private static void examplePersistenceArea(EntityManager em) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Object mutex = new Object();

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                synchronized (mutex) {
                    Category category1 = em.find(Category.class, InitData.getCategory1().getId());
                    category1.setName("Updated Name");
                    em.merge(category1);

                    System.out.println("Changed name.Waiting notification...");

                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Continue working after waiting");
                }
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                synchronized (mutex) {
                    Category category1 = em.find(Category.class, InitData.getCategory1().getId());
                    System.out.println("Read value: " + category1.getName());
                    mutex.notifyAll();
                }
            }
        };

        em.getTransaction().begin();

        threadPool.submit(run1);
        ThreadUtil.uncheckedSleep(2);
        threadPool.submit(run2);

        em.getTransaction().rollback();

        threadPool.shutdown();
    }


}
