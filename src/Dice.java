import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Dice extends JPanel {

    //integer roll will hold the dice's random roll
    private int roll;
    private int doubledRoll;

    //creating buffered images one through 6 for each possible face of the dice roll
    private BufferedImage diceImg;

    //integers x and y for the coordinates of each dice
    private final int x;
    private final int y;

    //Constructor takes in coordinates for the position of the new dice
    public Dice(int x, int y){
        this.x = x;
        this.y = y;
    }

    //roll method for casting the dice - random value between 1 and 6 inclusive assigned to integer roll
    public int roll() {
        Random random = new Random();
        roll = random.nextInt(6) + 1;
        doubledRoll=roll;
        return roll;
    }

    //getter for roll method
    public int getRoll() {
        return doubledRoll;
    }

    //Setter for roll method
    public void doubleRoll() {
        doubledRoll*=2;
    }

    //getter for cords - testing mainly
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    //method for drawing the dice
    public void draw(Graphics2D graphics) {

        //Switch statement for drawing only what side is rolled
        //Try and catch is the most efficient way of assigning an image to a class
        //It isn't storing the 24 (ie. 4 dice * 6 possible images) possible combinations
        //It's only storing 4 dice and overriding the images as each is needed
        try{
            switch(roll) {
                case 1:
                    diceImg = ImageIO.read(this.getClass().getResource("res/DiceImages/Dice1.jpg"));
                    graphics.drawImage(diceImg, x, y, 45, 45, null);
                    break;

                case 2:
                    diceImg = ImageIO.read(this.getClass().getResource("res/DiceImages/Dice2.jpg"));
                    graphics.drawImage(diceImg, x, y, 45, 45, null);
                    break;

                case 3:
                    diceImg = ImageIO.read(this.getClass().getResource("res/DiceImages/Dice3.jpg"));
                    graphics.drawImage(diceImg, x, y, 45, 45, null);
                    break;

                case 4:
                    diceImg = ImageIO.read(this.getClass().getResource("res/DiceImages/Dice4.jpg"));
                    graphics.drawImage(diceImg, x, y, 45, 45, null);
                    break;

                case 5:
                    diceImg = ImageIO.read(this.getClass().getResource("res/DiceImages/Dice5.jpg"));
                    graphics.drawImage(diceImg, x, y, 45, 45, null);
                    break;

                case 6:
                    diceImg = ImageIO.read(this.getClass().getResource("res/DiceImages/Dice6.jpg"));
                    graphics.drawImage(diceImg, x, y, 45, 45, null);
                    break;
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
