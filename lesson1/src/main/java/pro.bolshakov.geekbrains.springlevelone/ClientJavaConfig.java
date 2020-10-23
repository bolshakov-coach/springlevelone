package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientJavaConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Camera cameraComponent = context.getBean("cameraComponent", Camera.class);
        cameraComponent.doPhotograph();

        cameraComponent.breaking();

        cameraComponent.doPhotograph();

        //get new
        System.out.println("give me new camera!");
        Camera cameraComponentNew = context.getBean("cameraComponent", Camera.class);
        cameraComponentNew.doPhotograph();

        Cup cupComponent = context.getBean("cupComponent", Cup.class);
        cupComponent.doDrink();

        cupComponent.breaking();

        cupComponent.doDrink();

        //get new
        System.out.println("give me new cup!");
        Cup cupComponentNew = context.getBean("cupComponent", Cup.class);
        cupComponentNew.doDrink();

    }
}
