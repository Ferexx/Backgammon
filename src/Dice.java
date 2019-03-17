import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Dice extends JPanel {

    //integer roll will hold the dice's random roll
    private int roll;

    //creating buffered images one through 6 for each possible face of the dice roll
    private BufferedImage diceImg;

    //integers x and y for the coordinates of each dice
    private int x, y;

    //Constructor takes in coordinates for the position of the new dice
    public Dice(Window window, int x, int y){
        this.x = x;
        this.y = y;
    }

    //roll method for casting the dice - random value between 1 and 6 inclusive assigned to integer roll
    public void roll() {
        Random random = new Random();
        roll = random.nextInt(6) + 1;
    }

    //getter for roll method
    public int getRoll() {
        return roll;
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
        switch(roll) {
            case 1:
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                    System.out.println("image 1");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                graphics.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 2:
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                    System.out.println("image 2");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                graphics.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 3:
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                    System.out.println("image 3");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                graphics.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 4:
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                    System.out.println("image 4");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                graphics.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 5:
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                    System.out.println("image 5");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                graphics.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 6:
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                    System.out.println("image 6");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                graphics.drawImage(diceImg, x, y, 45, 45, null);
                break;
        }
    }
}
