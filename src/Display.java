import javax.sound.sampled.*;
import java.io.*;

public class Display {

    public static int WIDTH = 1280, HEIGHT = 720;

    public static final String TITLE = "Backgammon Window - Pre-Alpha v0.9";

    Display() {
        new Window(WIDTH, HEIGHT, TITLE);
        new Screen();
        playSound();
    }
    public void playSound()  {

        //Sound file for launching game - credit to Ankish
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/Resources/Ankish.wav"));
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
