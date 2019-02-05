public class Display {

    public static int WIDTH = 1280, HEIGHT = 720;

    public static final String TITLE = "Backgammon Window - Pre-Alpha v1.0";

    Display() {
        new Window(WIDTH, HEIGHT, TITLE);
        SoundManager.playSound();
    }
}
