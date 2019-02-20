import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Dice extends JPanel {

    //Image icon declaration for board
    private BufferedImage dice1Img;
    private BufferedImage dice2Img;
    private BufferedImage dice3Img;
    private BufferedImage dice4Img;
    private BufferedImage dice5Img;
    private BufferedImage dice6Img;
    private Graphics2D g;
    private int diceRollP1_1;
    private int diceRollP1_2;

    public Dice(){
        //SoundManager.playSound();
        try {
            dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
            dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
            dice3Img = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
            dice4Img = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
            dice5Img = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
            dice6Img = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Random random = new Random();
        int diceRollP1_1 = random.nextInt(6) + 1;
        int diceRollP1_2 = random.nextInt(6) + 1;
    }

    private void update() {
        revalidate();
        repaint();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        g = (Graphics2D) graphics;
        //Draw Dice1
        g.drawImage(dice1Img,128,0,45, 45, null);
    }

    public String getDice1() {
        return "\nPlayer 1 - Your dice rolls are " + diceRollP1_1 + " and " + diceRollP1_2 + "";
    }

    /*public String getDice2() {
        return "\nPlayer 2 - Your dice rolls are " + diceRollP2_1 + " and " + diceRollP2_2 + "";
    }*/
}