import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Dice {

    private static ImageIcon image1;
    private static ImageIcon image2;

    Dice() {

    }

    public static void drawDice(Window window) {

        Random random = new Random();
        int diceRoll1 = random.nextInt(6) + 1;
        int diceRoll2 = random.nextInt(6) + 1;
        System.out.println("\nYour dice rolls are " + diceRoll1 + " and " + diceRoll2);

        //PLAYER 1 DICE

        //If playerplaying (currently set in Controller)
        if(Controller.PlayerPlaying == "Player2") {
            //PLAYER 1 DICE 1 CREATION
            if (diceRoll1 == 1) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice1.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(260, 350, 0, 0));
            } else if (diceRoll1 == 2) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice2.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(260, 350, 0, 0));
            } else if (diceRoll1 == 3) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice3.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(260, 350, 0, 0));
            } else if (diceRoll1 == 4) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice4.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(260, 350, 0, 0));
            } else if (diceRoll1 == 5) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice5.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(260, 350, 0, 0));
            } else if (diceRoll1 == 6) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice6.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(260, 350, 0, 0));
            }

            //PLAYER 1 DICE 2 CREATION
            if (diceRoll2 == 1) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice1.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(360, 0, 8, 0));
            } else if (diceRoll2 == 2) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice2.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(360, 0, 8, 0));
            } else if (diceRoll2 == 3) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice3.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(360, 0, 8, 0));
            } else if (diceRoll2 == 4) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice4.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(360, 0, 8, 0));
            } else if (diceRoll2 == 5) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice5.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(360, 0, 8, 0));
            } else if (diceRoll2 == 6) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice6.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(360, 0, 8, 0));
            }
        }

        //PLAYER 2 DICE

        //If playerplaying (currently set in Controller)
        if(Controller.PlayerPlaying == "Player1") {
            //PLAYER 2 DICE 1 CREATION
            if (diceRoll1 == 1) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice1.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(0, 350, 390, 0));
            } else if (diceRoll1 == 2) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice2.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(0, 350, 390, 0));
            } else if (diceRoll1 == 3) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice3.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(0, 350, 390, 0));
            } else if (diceRoll1 == 4) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice4.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(0, 350, 390, 0));
            } else if (diceRoll1 == 5) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice5.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(0, 350, 390, 0));
            } else if (diceRoll1 == 6) {
                image1 = new ImageIcon(window.getClass().getResource("Resources/Dice6.jpg"));
                Window.dieLabel1 = new JLabel(image1);
                Window.dieLabel1.setBorder(new EmptyBorder(0, 350, 390, 0));
            }

            //PLAYER 2 DICE 2 CREATION
            if (diceRoll2 == 1) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice1.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(60, 0, 360, 0));
            } else if (diceRoll2 == 2) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice2.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(60, 0, 360, 0));
            } else if (diceRoll2 == 3) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice3.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(60, 0, 360, 0));
            } else if (diceRoll2 == 4) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice4.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(60, 0, 360, 0));
            } else if (diceRoll2 == 5) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice5.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(60, 0, 360, 0));
            } else if (diceRoll2 == 6) {
                image2 = new ImageIcon(window.getClass().getResource("Resources/Dice6.jpg"));
                Window.dieLabel2 = new JLabel(image2);
                Window.dieLabel2.setBorder(new EmptyBorder(60, 0, 360, 0));
            }
        }
    }
}
