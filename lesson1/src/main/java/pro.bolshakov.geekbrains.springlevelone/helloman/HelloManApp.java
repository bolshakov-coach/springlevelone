package pro.bolshakov.geekbrains.springlevelone.helloman;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloManApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configHelloMan.xml");
        HelloMan helloMan1 = context.getBean("helloMan1", HelloMan.class);
        helloMan1.helloSay();

        HelloMan helloMan2 = context.getBean("helloMan2", HelloMan.class);
        helloMan2.helloSay();

        HelloMan helloMan3 = context.getBean("helloMan3", HelloMan.class);
        helloMan3.helloSay();

        ApplicationContext contextJavaConfig = new AnnotationConfigApplicationContext(HelloManConfig.class);
        HelloMan helloManJC = contextJavaConfig.getBean("helloManJC", HelloMan.class);
        helloManJC.helloSay();

        HelloMan helloSayAnno = contextJavaConfig.getBean("helloSayAnno", HelloMan.class);
        helloSayAnno.helloSay();

    }
}
