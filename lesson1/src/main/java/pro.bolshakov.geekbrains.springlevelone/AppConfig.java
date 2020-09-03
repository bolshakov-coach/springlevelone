package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "cameraRoll")
    public CameraRoll cameraRoll(){
        return new ColorCameraRoll();
    }

    @Bean(name = "camera")
    public Camera camera(CameraRoll cameraRoll){
        return new CameraImpl(cameraRoll);
    }
}
