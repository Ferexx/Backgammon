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
    private BufferedImage diceImg1;
    private BufferedImage diceImg2;
    private BufferedImage diceImg3;
    private BufferedImage diceImg4;
    private BufferedImage diceImg5;
    private BufferedImage diceImg6;
    private Graphics2D g;

    //integers x and y for the coordinates of each dice
    int x, y;

    public Dice(Window window){

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

    //setter for the cords for the dice coordinates - BETA IDEA
    public void setCords(int x, int y){
        this.x = x;
        this.y = y;
    }

    //method for drawing the dice
    //TODO figure out how to assign the coordinates for each of the 4 proposed instances of the dice
    public void draw(Graphics2D graphics) {
        g = graphics;

        //Assigning Dice images and storing them as they will all be used undoubtedly at some stage
        try {
            BufferedImage diceImg1 = ImageIO.read(this.getClass().getResource("Resources/Dice1.jpg"));
            BufferedImage diceImg2 = ImageIO.read(this.getClass().getResource("Resources/Dice2.jpg"));
            BufferedImage diceImg3 = ImageIO.read(this.getClass().getResource("Resources/Dice3.jpg"));
            BufferedImage diceImg4 = ImageIO.read(this.getClass().getResource("Resources/Dice4.jpg"));
            BufferedImage diceImg5 = ImageIO.read(this.getClass().getResource("Resources/Dice5.jpg"));
            BufferedImage diceImg6 = ImageIO.read(this.getClass().getResource("Resources/Dice6.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        //Switch statement for drawing only what side is rolled
        switch(roll) {
            case 1:
                roll = 1;
                g.drawImage(diceImg1, x, y, 45, 45, null);
                break;

            case 2:
                roll = 2;
                g.drawImage(diceImg2, x, y, 45, 45, null);
                break;

            case 3:
                roll = 1;
                g.drawImage(diceImg3, x, y, 45, 45, null);
                break;

            case 4:
                roll = 4;
                g.drawImage(diceImg4, x, y, 45, 45, null);
                break;

            case 5:
                roll = 1;
                g.drawImage(diceImg5, x, y, 45, 45, null);
                break;

            case 6:
                roll = 1;
                g.drawImage(diceImg6, x, y, 45, 45, null);
                break;
        }
    }
}
