import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

//Big reworks here to make the dice work. Most of them are temporary, do not worry. Code was essentially reverted
//and suited to fit the new way of things
//I'm working on the actual efficient way of doing this, but for the meantime, this is how it shall be done

public class diceHandler extends JPanel {

    //Image icon declaration for board
    private BufferedImage diceImg1;
    private BufferedImage diceImg2;
    private BufferedImage diceImg3;
    private BufferedImage diceImg4;
    private Graphics2D g;
    public int diceRoll1;
    public int diceRoll2;
    public int diceRoll3;
    public int diceRoll4;

    public diceHandler(Window window){
        //SoundManager.playSound();
        rollDice1(window);

        //Setting cords for each instance of Dice
        window.p1D1.setCords(86, 120);
        window.p1D2.setCords(140, 166);
        window.p2D1.setCords(86, 420);
        window.p2D2.setCords(140, 466);

    }

    //reroll method for player 1
    public void rollDice1(Window window) {
        Random random = new Random();
        diceRoll1 = random.nextInt(6) + 1;
        window.drawing.update();
    }
    public void rollDice2(Window window) {
        Random random = new Random();
        diceRoll2 = random.nextInt(6) + 1;
        window.drawing.update();
    }
    public void rollDice3(Window window) {
        Random random = new Random();
        diceRoll3 = random.nextInt(6) + 1;
        window.drawing.update();
    }
    public void rollDice4(Window window) {
        Random random = new Random();
        diceRoll4 = random.nextInt(6) + 1;
        window.drawing.update();
    }

    public void drawDice(Graphics2D graphics) {
        g = graphics;
        //Draw diceHandler
        //ImageIO.read is set in the switch statement as it is more memory efficient than storing the 6 dice values all the time

        switch (diceRoll1) {
            case 1:
                diceRoll1 = 1;
                try {
                    diceImg1 = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg1, 86, 120, 45, 45, null);
                break;
            case 2:
                diceRoll1 = 2;
                try {
                    diceImg1 = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg1, 86, 120, 45, 45, null);
                break;
            case 3:
                diceRoll1 = 3;
                try {
                    diceImg1 = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg1, 86, 120, 45, 45, null);
                break;
            case 4:
                diceRoll1 = 4;
                try {
                    diceImg1 = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg1, 86, 120, 45, 45, null);
                break;
            case 5:
                diceRoll1 = 5;
                try {
                    diceImg1 = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg1, 86, 120, 45, 45, null);
                break;
            case 6:
                diceRoll1 = 6;
                try {
                    diceImg1 = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg1, 86, 120, 45, 45, null);
                break;
        }
        switch (diceRoll2) {
            case 1:
                diceRoll2 = 1;
                try {
                    diceImg2 = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg2, 140, 166, 45, 45, null);
                break;
            case 2:
                diceRoll2 = 2;
                try {
                    diceImg2 = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg2, 140, 166, 45, 45, null);
                break;
            case 3:
                diceRoll2 = 3;
                try {
                    diceImg2 = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg2, 140, 166, 45, 45, null);
                break;
            case 4:
                diceRoll2 = 4;
                try {
                    diceImg2 = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg2, 140, 166, 45, 45, null);
                break;
            case 5:
                diceRoll2 = 5;
                try {
                    diceImg2 = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg2, 140, 166, 45, 45, null);
                break;
            case 6:
                diceRoll2 = 6;
                try {
                    diceImg2 = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg2, 140, 166, 45, 45, null);
                break;
        }
        switch (diceRoll3) {
            case 1:
                diceRoll3 = 1;
                try {
                    diceImg3 = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg3, 86, 420, 45, 45, null);
                break;
            case 2:
                diceRoll3 = 2;
                try {
                    diceImg3 = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg3, 86, 420, 45, 45, null);
                break;
            case 3:
                diceRoll3 = 3;
                try {
                    diceImg3 = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg3, 86, 420, 45, 45, null);
                break;
            case 4:
                diceRoll3 = 4;
                try {
                    diceImg3 = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg3, 86, 420, 45, 45, null);
                break;
            case 5:
                diceRoll3 = 5;
                try {
                    diceImg3 = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg3, 86, 420, 45, 45, null);
                break;
            case 6:
                diceRoll3 = 6;
                try {
                    diceImg3 = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg3, 86, 420, 45, 45, null);
                break;
        }
        switch (diceRoll4) {
            case 1:
                diceRoll4 = 1;
                try {
                    diceImg4 = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg4, 140, 466, 45, 45, null);
                break;
            case 2:
                diceRoll4 = 2;
                try {
                    diceImg4 = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg4, 140, 466, 45, 45, null);
                break;
            case 3:
                diceRoll4 = 3;
                try {
                    diceImg4 = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg4, 140, 466, 45, 45, null);
                break;
            case 4:
                diceRoll4 = 4;
                try {
                    diceImg4 = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg4, 140, 466, 45, 45, null);
                break;
            case 5:
                diceRoll4 = 5;
                try {
                    diceImg4 = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg4, 140, 466, 45, 45, null);
                break;
            case 6:
                diceRoll4 = 6;
                try {
                    diceImg4 = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg4, 140, 466, 45, 45, null);
                break;
        }
    }

    //Getters for Die values
    public int getDice1Value() {
        return diceRoll1;
    }
    public int getDice2Value() {
        return diceRoll2;
    }
    public int getDice3Value() {
        return diceRoll3;
    }
    public int getDice4Value() {
        return diceRoll4;
    }

}