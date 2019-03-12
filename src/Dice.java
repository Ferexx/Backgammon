import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Dice extends JPanel {

    //Image icon declaration for board
    private BufferedImage diceImg;
    private Graphics2D g;
    public int diceRoll;

    public Dice(Window window){
        //SoundManager.playSound();
        rerollDice(window);
    }

    //reroll method for player 1
    public void rerollDice(Window window) {
        Random random = new Random();
        diceRoll = random.nextInt(6) + 1;
        window.drawing.update();
    }

    public void drawDice(Graphics2D graphics) {
        g = graphics;
        //Draw Dice
        //ImageIO.read is set in the switch statement as it is more memory efficient than storing the 6 dice values all the time
        switch (diceRoll) {
            case 1:
                diceRoll = 1;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                if(Game.currentPlayer) {
                    g.drawImage(diceImg, 86, 120, 45, 45, null);
                }
                else {
                    g.drawImage(diceImg, 86, 420, 45, 45, null);
                }
                break;
            case 2:
                diceRoll = 2;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                if(Game.currentPlayer) {
                    g.drawImage(diceImg, 86, 120, 45, 45, null);
                }
                else {
                    g.drawImage(diceImg, 86, 420, 45, 45, null);
                }
                break;
            case 3:
                diceRoll = 3;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                if(Game.currentPlayer) {
                    g.drawImage(diceImg, 86, 120, 45, 45, null);
                }
                else {
                    g.drawImage(diceImg, 86, 420, 45, 45, null);
                }
                break;
            case 4:
                diceRoll = 4;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                if(Game.currentPlayer) {
                    g.drawImage(diceImg, 86, 120, 45, 45, null);
                }
                else {
                    g.drawImage(diceImg, 86, 420, 45, 45, null);
                }
                break;
            case 5:
                diceRoll = 5;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                if(Game.currentPlayer) {
                    g.drawImage(diceImg, 86, 120, 45, 45, null);
                }
                else {
                    g.drawImage(diceImg, 86, 420, 45, 45, null);
                }
                break;
            case 6:
                diceRoll = 6;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                if(Game.currentPlayer) {
                    g.drawImage(diceImg, 86, 120, 45, 45, null);
                }
                else {
                    g.drawImage(diceImg, 86, 420, 45, 45, null);
                }
                break;
        }
    }

    //Getters for Die values
    public int getDiceValue() {
        return diceRoll;
    }

}