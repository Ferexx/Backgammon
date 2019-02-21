import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Dice extends JPanel {

    //Image icon declaration for board
    private BufferedImage p1Dice1Img;
    private BufferedImage p1Dice2Img;
    private BufferedImage p2Dice1Img;
    private BufferedImage p2Dice2Img;
    private Graphics2D g;
    int numOfDice = 6;
    Random random = new Random();
    int diceRollP1_1 = random.nextInt(6) + 1;
    int diceRollP1_2 = random.nextInt(6) + 1;
    int diceRollP2_1 = random.nextInt(6) + 1;
    int diceRollP2_2 = random.nextInt(6) + 1;

    public Dice(){
        //SoundManager.playSound();
    }

    public void drawDice(Graphics2D graphics, Boolean player1) {
        super.paintComponent(graphics);
        g = graphics;

        //Draw Dice
        //ImageIO.read is set in the switch statement as it is more memory efficient than storing the 6 dice values all the time
        if(player1) {
                if (diceRollP1_1 == 1) {
                    try {
                        p1Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice1Img, 86, 120, 45, 45, null);
                } else if (diceRollP1_1 == 2) {
                    try {
                        p1Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice1Img, 86, 120, 45, 45, null);
                } else if (diceRollP1_1 == 3) {
                    try {
                        p1Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice1Img, 86, 120, 45, 45, null);
                } else if (diceRollP1_1 == 4) {
                    try {
                        p1Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice1Img, 86, 120, 45, 45, null);
                } else if (diceRollP1_1 == 5) {
                    try {
                        p1Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice1Img, 86, 120, 45, 45, null);
                } else if (diceRollP1_1 == 6) {
                    try {
                        p1Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice1Img, 86, 120, 45, 45, null);
                }

                //PLAYER 1 DICE 2 CREATION
                if (diceRollP1_2 == 1) {
                    try {
                        p1Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice2Img, 140, 166, 45, 45, null);
                } else if (diceRollP1_2 == 2) {
                    try {
                        p1Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice2Img, 140, 166, 45, 45, null);
                } else if (diceRollP1_2 == 3) {
                    try {
                        p1Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice2Img, 140, 166, 45, 45, null);
                } else if (diceRollP1_2 == 4) {
                    try {
                        p1Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice2Img, 140, 166, 45, 45, null);
                } else if (diceRollP1_2 == 5) {
                    try {
                        p1Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice2Img, 140, 166, 45, 45, null);
                } else if (diceRollP1_2 == 6) {
                    try {
                        p1Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                    } catch (IOException e){
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p1Dice2Img, 140, 166, 45, 45, null);
                }

        } else {    //Else for player 2 fheuska
            //PLAYER 2 DICE 1 CREATION
            switch(numOfDice) {
                case 1: diceRollP2_1 = 1;
                    try {
                        p2Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice1Img, 86, 420, 45, 45, null);
                    break;
                case 2: diceRollP2_1 = 2;
                    try {
                        p2Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice1Img, 86, 420, 45, 45, null);
                    break;
                case 3: diceRollP2_1 = 3;
                    try {
                        p2Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice1Img, 86, 420, 45, 45, null);
                    break;
                case 4: diceRollP2_1 = 4;
                    try {
                        p2Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice1Img, 86, 420, 45, 45, null);
                    break;
                case 5: diceRollP2_1 = 5;
                    try {
                        p2Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice1Img, 86, 420, 45, 45, null);
                    break;
                case 6: diceRollP2_1 = 6;
                    try {
                        p2Dice1Img = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice1Img, 86, 420, 45, 45, null);
                    break;
                }
            switch(numOfDice){
                //PLAYER 2 DICE 2 CREATION
                case 1: diceRollP2_2 = 1;
                    try {
                        p2Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice2Img, 140, 466, 45, 45, null);
                    break;
                case 2: diceRollP2_2 = 2;
                    try {
                        p2Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice2Img, 140, 466, 45, 45, null);
                    break;
                case 3: diceRollP2_2 = 3;
                    try {
                        p2Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice2Img, 140, 466, 45, 45, null);
                    break;
                case 4: diceRollP2_2 = 4;
                    try {
                        p2Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice2Img, 140, 466, 45, 45, null);
                    break;
                case 5: diceRollP2_2 = 5;
                    try {
                        p2Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice2Img, 140, 466, 45, 45, null);
                    break;
                case 6: diceRollP2_2 = 6;
                    try {
                        p2Dice2Img = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                    g.drawImage(p2Dice2Img, 140, 466, 45, 45, null);
                    break;
                default: diceRollP2_2 = 0;
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
