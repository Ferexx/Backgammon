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
    private Graphics2D g;
    public int diceRoll1;
    public int diceRoll2;

    public Dice(){
        //SoundManager.playSound();
        rerollDice();
    }

    //reroll method for player 1
    public void rerollDice() {
        Random random = new Random();
        diceRoll1 = random.nextInt(6) + 1;
        diceRoll2 = random.nextInt(6) + 1;
    }

    public void drawDice(Graphics2D graphics) {
        super.paintComponent(graphics);
        g = graphics;
        //Draw Dice
        //ImageIO.read is set in the switch statement as it is more memory efficient than storing the 6 dice values all the time
        switch (diceRoll1) {
            case 1:
                diceRoll1 = 1;
                try {
                    dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice1Img, 86, 120, 45, 45, null);
                break;
            case 2:
                diceRoll1 = 2;
                try {
                    dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice1Img, 86, 120, 45, 45, null);
                break;
            case 3:
                diceRoll1 = 3;
                try {
                    dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice1Img, 86, 120, 45, 45, null);
                break;
            case 4:
                diceRoll1 = 4;
                try {
                    dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice1Img, 86, 120, 45, 45, null);
                break;
            case 5:
                diceRoll1 = 5;
                try {
                    dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice1Img, 86, 120, 45, 45, null);
                break;
            case 6:
                diceRoll1 = 6;
                try {
                    dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice1Img, 86, 120, 45, 45, null);
                break;
        }
        switch (diceRoll2) {
            case 1:
                diceRoll2 = 1;
                try {
                    dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice2Img, 140, 166, 45, 45, null);
                break;
            case 2:
                diceRoll2 = 2;
                try {
                    dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice2Img, 140, 166, 45, 45, null);
                break;
            case 3:
                diceRoll2 = 3;
                try {
                    dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice2Img, 140, 166, 45, 45, null);
                break;
            case 4:
                diceRoll2 = 4;
                try {
                    dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice2Img, 140, 166, 45, 45, null);
                break;
            case 5:
                diceRoll2 = 5;
                try {
                    dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice2Img, 140, 166, 45, 45, null);
                break;
            case 6:
                diceRoll2 = 6;
                try {
                    dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(dice2Img, 140, 166, 45, 45, null);
                break;
        }
    }

    //Getters for Die values
    public int getDice1() {
        return diceRoll1;
    }
    public int getDice2() {
        return diceRoll2;
    }
    public int getDiceTotal() {
        return diceRoll1 + diceRoll1;
    }

}