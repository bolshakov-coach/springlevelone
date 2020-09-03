package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cameraComponent")
@Scope("prototype")
public class CameraComponentImpl implements Camera {

    private CameraRoll cameraRoll;
    @Value("false")
    private boolean broken;

    public void doPhotograph() {
        if (broken) {
            System.out.println("Camera is BROKEN!!!");
            return;
        }
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

    @Override
    public void breaking() {
        this.broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}
