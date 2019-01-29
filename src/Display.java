import javax.sound.sampled.*;
import java.io.*;

public class Display {

    public static int WIDTH = 1280, HEIGHT = 720;

    public static final String TITLE = "Backgammon Window - Pre-Alpha v0.8";

    Display() {
        new Window(WIDTH, HEIGHT, TITLE);
        new Screen();
        playSound();
    }
    public void playSound()  {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/Graphics/Ankish.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }
}
