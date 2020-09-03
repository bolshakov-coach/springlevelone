package pro.bolshakov.geekbrains.springlevelone;

public class Client {
    public static void main(String[] args) {
        ColorCameraRoll colorCameraRoll = new ColorCameraRoll();
        Camera camera = new Camera(colorCameraRoll);
        camera.doPhotograph();

        BlackWhiteCameraRoll blackWhiteCameraRoll = new BlackWhiteCameraRoll();
        camera.setCameraRoll(blackWhiteCameraRoll);
        camera.doPhotograph();
    }
}
