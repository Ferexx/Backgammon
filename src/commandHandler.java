import com.sun.corba.se.impl.activation.CommandHandler;

import javax.swing.*;

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
        player1 = new Player(p1);
        player2 = new Player(p2);
        window.infoLabel.append("\nWelcome to the game " + player1.getName() + ".");
        window.infoLabel.append("\nWelcome to the game " + player2.getName() + ".");
    }

    //Handler for catching events. We'll catch strings, find their meaning then convert them to actual appendages using if statements.
    public void appendText(String text, Window window) {
        if(text.equalsIgnoreCase("quit")) {
            catchQuit();
        }
        if(text.equalsIgnoreCase("1 3")) {
            //Window.board.move(Controller.pointList[0], Controller.pointList[2]);
        }

        //Turn handler
        if(text.equalsIgnoreCase("next")) {
            Game.currentPlayer = !Game.currentPlayer;
            if(Game.currentPlayer)
            {
                window.infoLabel.append("\nIt is now your turn " + player1.getName());
            }

            if(!Game.currentPlayer)
            {
                window.infoLabel.append("\nIt is now your turn " + player2.getName());
            }
        }

        //Testing and debug
        else {
            window.infoLabel.append("\n" + text);
        }

    }

    //Used for restarting the game
    public void restartText(Window window) {
        window.infoLabel.setText(null);
        window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Conway.\n\n");
        window.infoLabel.append("\nPlayer 1, please enter your name.");

    }

    //Quits
    private void catchQuit() {
        System.exit(0);
    }
}
