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
    private int diceRollP2_1;
    private int diceRollP2_2;

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
    }

    public void drawDice(Graphics2D graphics, Boolean player1) {
        super.paintComponent(graphics);
        g = graphics;

        //Draw Dice1

        Random random = new Random();
        int diceRollP1_1 = random.nextInt(6) + 1;
        int diceRollP1_2 = random.nextInt(6) + 1;
        int diceRollP2_1 = random.nextInt(6) + 1;
        int diceRollP2_2 = random.nextInt(6) + 1;

        if(player1) {

            if (diceRollP1_1 == 1) {
                g.drawImage(dice1Img, 150, 50, 45, 45, null);
            } else if (diceRollP1_1 == 2) {
                g.drawImage(dice2Img, 150, 50, 45, 45, null);
            } else if (diceRollP1_1 == 3) {
                g.drawImage(dice3Img, 150, 50, 45, 45, null);
            } else if (diceRollP1_1 == 4) {
                g.drawImage(dice4Img, 150, 50, 45, 45, null);
            } else if (diceRollP1_1 == 5) {
                g.drawImage(dice5Img, 150, 50, 45, 45, null);
            } else if (diceRollP1_1 == 6) {
                g.drawImage(dice6Img, 150, 50, 45, 45, null);
            }

            //PLAYER 1 DICE 2 CREATION
            if (diceRollP1_2 == 1) {
                g.drawImage(dice1Img, 200, 100, 45, 45, null);
            } else if (diceRollP1_2 == 2) {
                g.drawImage(dice2Img, 200, 100, 45, 45, null);
            } else if (diceRollP1_2 == 3) {
                g.drawImage(dice3Img, 200, 100, 45, 45, null);
            } else if (diceRollP1_2 == 4) {
                g.drawImage(dice4Img, 200, 100, 45, 45, null);
            } else if (diceRollP1_2 == 5) {
                g.drawImage(dice5Img, 200, 100, 45, 45, null);
            } else if (diceRollP1_2 == 6) {
                g.drawImage(dice6Img, 200, 100, 45, 45, null);
            }
        } else {

            if (diceRollP2_1 == 1) {
                g.drawImage(dice1Img, 150, 500, 45, 45, null);
            } else if (diceRollP2_1 == 2) {
                g.drawImage(dice2Img, 150, 500, 45, 45, null);
            } else if (diceRollP2_1 == 3) {
                g.drawImage(dice3Img, 150, 500, 45, 45, null);
            } else if (diceRollP2_1 == 4) {
                g.drawImage(dice4Img, 150, 500, 45, 45, null);
            } else if (diceRollP2_1 == 5) {
                g.drawImage(dice5Img, 150, 500, 45, 45, null);
            } else if (diceRollP2_1 == 6) {
                g.drawImage(dice6Img, 150, 500, 45, 45, null);
            }

            //PLAYER 2 DICE 2 CREATION
            if (diceRollP2_2 == 1) {
                g.drawImage(dice1Img, 200, 550, 45, 45, null);
            } else if (diceRollP2_2 == 2) {
                g.drawImage(dice2Img, 200, 550, 45, 45, null);
            } else if (diceRollP2_2 == 3) {
                g.drawImage(dice3Img, 200, 550, 45, 45, null);
            } else if (diceRollP2_2 == 4) {
                g.drawImage(dice4Img, 200, 550, 45, 45, null);
            } else if (diceRollP2_2 == 5) {
                g.drawImage(dice5Img, 200, 550, 45, 45, null);
            } else if (diceRollP2_2 == 6) {
                g.drawImage(dice6Img, 200, 550, 45, 45, null);
            }
        }
    }

    public String getDice1() {
        return "\nPlayer 1 - Your dice rolls are " + diceRollP1_1 + " and " + diceRollP1_2 + "";
    }

    public String getDice2() {
        return "\nPlayer 2 - Your dice rolls are " + diceRollP2_1 + " and " + diceRollP2_2 + "";
    }
}