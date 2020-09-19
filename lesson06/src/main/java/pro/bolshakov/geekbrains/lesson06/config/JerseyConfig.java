package pro.bolshakov.geekbrains.lesson06.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import pro.bolshakov.geekbrains.lesson06.controller.MainController;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(MainController.class);
    }
}
