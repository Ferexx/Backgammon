import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Dice extends JPanel {

    //integer for roll will hold the dice's random roll
    private int roll;

    //creating buffered images 1 through 6 for each possible face of the dice roll
    BufferedImage diceImg;
    Graphics2D g;

    //integers x and y for the coordinates of each dice
    private int x, y;

    public Dice(Window window){

    }

    //roll method for casting the dice - random value between 1 and 6 inclusive assigned to integer roll
    public void roll(Window window) {
        Random random = new Random();
        roll = random.nextInt(6) + 1;
    }

    //getter for roll method
    public int getRoll() {
        return roll;
    }

    //setter for the cords for the dice coordinates - BETA IDEA
    public void setCords(int x, int y){
        this.x = x;
        this.y = y;
    }

    //getter for cords
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    //method for drawing the dice
    //TODO figure out how to assign the coordinates for each of the 4 proposed instances of the dice
    public void draw(Graphics2D graphics) {
        g = graphics;

        //Switch statement for drawing only what side is rolled
        switch(roll) {
            case 1:
                roll = 1;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
                    System.out.println("image 1");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 2:
                roll = 2;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
                    System.out.println("image 2");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 3:
                roll = 3;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
                    System.out.println("image 3");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 4:
                roll = 4;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
                    System.out.println("image 4");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 5:
                roll = 5;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
                    System.out.println("image 5");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg, x, y, 45, 45, null);
                break;

            case 6:
                roll = 6;
                try {
                    diceImg = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
                    System.out.println("image 6");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                g.drawImage(diceImg, x, y, 45, 45, null);
                break;
        }
    }
}
