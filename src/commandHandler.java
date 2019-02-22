import javax.swing.*;
import java.util.Scanner;

class commandHandler {

    //Making these static as we may want to access these from anywhere in the game. Adding them to commandHandler as I feel they are relevant to this class.
    public static Player player1;
    public static Player player2;

    public commandHandler() {

    }

    public static void setNames(Window window) {
        //Player name getting
        JFrame p1frame = new JFrame("Player 1");
        JFrame p2frame = new JFrame("Player 2");
        String p1 = JOptionPane.showInputDialog(p1frame, "Player 1, please enter your name");
        String p2 = JOptionPane.showInputDialog(p2frame, "Player 2, please enter your name");
        player1 = new Player(p1, "Black");
        player2 = new Player(p2, "Red");
        window.infoLabel.append("\nWelcome to the game " + player1.getName() + ". Your colour is " + player1.getColour().toLowerCase() + ".");
        window.infoLabel.append("\nWelcome to the game " + player2.getName() + ". Your colour is " + player2.getColour().toLowerCase() + ".");
    }

    //Handler for catching events. We'll catch strings, find their meaning then convert them to actual appendages using if statements.
    public void appendText(String text, Window window) {
        if (text.equalsIgnoreCase("quit")) {
            catchQuit();
        }

        //Turn handler
        if (text.equalsIgnoreCase("next")) {
            Game.currentPlayer = !Game.currentPlayer;
            if (Game.currentPlayer) {
                window.infoLabel.append("\nIt is now your turn " + player1.getName() + ".");
            }

            if (!Game.currentPlayer) {
                window.infoLabel.append("\nIt is now your turn " + player2.getName() + ".");
            }
        }
        else {
            window.infoLabel.append("\n" + text);
        }
        window.drawing.update();

        try {
            Scanner sc = new Scanner(text);
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            sc.close();

            if(point1 > 25 || point2 > 27 || point1 < 0 || point2 < 0)
            {
                window.infoLabel.append("\nYour move is out of bounds.");
            }

            if(Game.pointList[point1].getCount() == 0)
            {
                window.infoLabel.append("\nThere is no checker on the starting point.");
            }
            else {
                if(Game.currentPlayer) {
                    window.drawing.move(Game.pointList[point1], Game.pointList[point2]);
                }
                else {
                    window.drawing.move(Game.pointList[23-point1], Game.pointList[23-point2]);
                }
            }
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    //Used for restarting the game
    public void restartText(Window window) {
        window.infoLabel.setText(null);
        window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Cobwag.\n\n");
    }

    //Quits
    private void catchQuit() {
        System.exit(0);
    }
}
