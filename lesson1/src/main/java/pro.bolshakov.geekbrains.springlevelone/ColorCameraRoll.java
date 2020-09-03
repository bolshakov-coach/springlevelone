package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
public class ColorCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("save a color photo");
    }
}
