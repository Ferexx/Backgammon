import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

class SoundManager {

    public static void playSound()  {

        //Sound file for launching game - credit to Ankish
        try {
            //AudioInputStream defaultSound = AudioSystem.getClass().getResource("resources/Ankish.wav");
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(""));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
