import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Dice {

    private static ImageIcon image1;
    private static ImageIcon image2;
    private static ImageIcon image3;
    private static ImageIcon image4;
    private static ImageIcon image5;
    private static ImageIcon image6;
    public static int diceRollP1_1;
    public static int diceRollP1_2;
    public static int diceRollP2_1;
    public static int diceRollP2_2;

    public static void dice(Window window) {

        //ASSIGNING DIE IMAGES TO VARIABLE
        image1 = new ImageIcon(window.getClass().getResource("Resources/Dice1.jpg"));
        image2 = new ImageIcon(window.getClass().getResource("Resources/Dice2.jpg"));
        image3 = new ImageIcon(window.getClass().getResource("Resources/Dice3.jpg"));
        image4 = new ImageIcon(window.getClass().getResource("Resources/Dice4.jpg"));
        image5 = new ImageIcon(window.getClass().getResource("Resources/Dice5.jpg"));
        image6 = new ImageIcon(window.getClass().getResource("Resources/Dice6.jpg"));

        //DRAWING DIE VIA METHODS BELOW
        //CALL ONE OF THESE TO ROLL JUST 1 SET OF DIE
        drawP1Dice(window);
        drawP2Dice(window);

        //SETS POSITION OF THE JLABEL
        Window.dieLabel1_1.setBorder(new EmptyBorder(0, 0, 250, 0));
        Window.dieLabel1_2.setBorder(new EmptyBorder(0, 0, 250, 0));
        Window.dieLabel2_1.setBorder(new EmptyBorder(500, 0, 0, 0));
        Window.dieLabel2_2.setBorder(new EmptyBorder(500, 0, 0, 0));

    }

    public static void drawP1Dice(Window window) {

        //Player 1 random roll
        Random random = new Random();
        diceRollP1_1 = random.nextInt(6) + 1;
        diceRollP1_2 = random.nextInt(6) + 1;
        System.out.println("\nPlayer 1 - Your dice rolls are " + diceRollP1_1 + " and " + diceRollP1_2);

        //PLAYER 1 DICE 1 CREATION
        if (diceRollP1_1 == 1) {
            Window.dieLabel1_1 = new JLabel(image1);
        } else if (diceRollP1_1 == 2) {
            Window.dieLabel1_1 = new JLabel(image2);
        } else if (diceRollP1_1 == 3) {
            Window.dieLabel1_1 = new JLabel(image3);
        } else if (diceRollP1_1 == 4) {
            Window.dieLabel1_1 = new JLabel(image4);
        } else if (diceRollP1_1 == 5) {
            Window.dieLabel1_1 = new JLabel(image5);
        } else if (diceRollP1_1 == 6) {
            Window.dieLabel1_1 = new JLabel(image6);
        }

        //PLAYER 1 DICE 2 CREATION
        if (diceRollP1_2 == 1) {
            Window.dieLabel1_2 = new JLabel(image1);
        } else if (diceRollP1_2 == 2) {
            Window.dieLabel1_2 = new JLabel(image2);
        } else if (diceRollP1_2 == 3) {
            Window.dieLabel1_2 = new JLabel(image3);
        } else if (diceRollP1_2 == 4) {
            Window.dieLabel1_2 = new JLabel(image4);
        } else if (diceRollP1_2 == 5) {
            Window.dieLabel1_2 = new JLabel(image5);
        } else if (diceRollP1_2 == 6) {
            Window.dieLabel1_2 = new JLabel(image6);
        }
    }

    public static void drawP2Dice(Window window) {
        //Player 2 random roll
        Random random = new Random();
        diceRollP2_1 = random.nextInt(6) + 1;
        diceRollP2_2 = random.nextInt(6) + 1;
        System.out.println("\nPlayer 2 - Your dice rolls are " + diceRollP2_1 + " and " + diceRollP2_2);
        //Window.infoLabel.append("Player 1, your dice rolls are " + diceRollP2_1 + " and " + diceRollP2_2);

        //PLAYER 2 DICE 1 CREATION
        if (diceRollP2_1 == 1) {
            Window.dieLabel2_1 = new JLabel(image1);
        } else if (diceRollP2_1 == 2) {
            Window.dieLabel2_1 = new JLabel(image2);
        } else if (diceRollP2_1 == 3) {
            Window.dieLabel2_1 = new JLabel(image3);
        } else if (diceRollP2_1 == 4) {
            Window.dieLabel2_1 = new JLabel(image4);
        } else if (diceRollP2_1 == 5) {
            Window.dieLabel2_1 = new JLabel(image5);
        } else if (diceRollP2_1 == 6) {
            Window.dieLabel2_1 = new JLabel(image6);
        }

        //PLAYER 2 DICE 2 CREATION
        if (diceRollP2_2 == 1) {
            Window.dieLabel2_2 = new JLabel(image1);
        } else if (diceRollP2_2 == 2) {
            Window.dieLabel2_2 = new JLabel(image2);
        } else if (diceRollP2_2 == 3) {
            Window.dieLabel2_2 = new JLabel(image3);
        } else if (diceRollP2_2 == 4) {
            Window.dieLabel2_2 = new JLabel(image4);
        } else if (diceRollP2_2 == 5) {
            Window.dieLabel2_2 = new JLabel(image5);
        } else if (diceRollP2_2 == 6) {
            Window.dieLabel2_2 = new JLabel(image6);
        }
    }

    public static String getDice1() {
        return "\nPlayer 1 - Your dice rolls are " + diceRollP1_1 + " and " + diceRollP1_2 + "";
    }

    public static String getDice2() {
        return "\nPlayer 2 - Your dice rolls are " + diceRollP2_1 + " and " + diceRollP2_2 + "";
    }

}
