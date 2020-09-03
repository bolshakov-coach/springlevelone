package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pro.bolshakov.geekbrains.springlevelone")
public class AppConfig {

    @Bean(name = "camera")
    public Camera camera(CameraRoll cameraRoll){
        return new CameraImpl(cameraRoll);
    }
}
