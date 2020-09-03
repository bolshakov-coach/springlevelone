package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cameraComponent")
public class CameraComponentImpl implements Camera{
    private CameraRoll cameraRoll;

    public void doPhotograph(){
        System.out.println("Chick - chick");
        cameraRoll.processing();
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Autowired
//    @Autowired(required = false)
    @Qualifier("blackWhiteCameraRoll")
    public void setCameraRoll(CameraRoll roll) {
        this.cameraRoll = roll;
    }
}
