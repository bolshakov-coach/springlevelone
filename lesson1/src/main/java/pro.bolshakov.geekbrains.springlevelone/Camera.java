package pro.bolshakov.geekbrains.springlevelone;

public interface Camera {
    void doPhotograph();
    CameraRoll getCameraRoll();
    void setCameraRoll(CameraRoll cameraRoll);
    void breaking();
    boolean isBroken();
}
