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

    }
}
