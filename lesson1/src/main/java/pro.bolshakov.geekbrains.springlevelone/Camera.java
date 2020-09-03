package pro.bolshakov.geekbrains.springlevelone;

public class Camera {
    private CameraRoll cameraRoll;

    public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void doPhotograph(){
        System.out.println("Chick - chick");
        cameraRoll.processing();
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }
}
