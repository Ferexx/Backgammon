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
        window.infoLabel.append("\nWelcome to the game " + player1.getName() + ". You are player 1, and your dice are on top. Your colour is " + player1.getColour().toLowerCase() + ".\n");
        window.infoLabel.append("\nWelcome to the game " + player2.getName() + ". You are player 2, and your dice are on the bottom. Your colour is " + player2.getColour().toLowerCase() + ".\n");
        setFirstTurn(window);
    }

    //Rolling to decide who goes first
    public static void setFirstTurn(Window window) {
        if((window.dice1.getDiceP1Total()) > (window.dice2.getDiceP2Total())) {
            window.infoLabel.append("\nPlayer 1 rolled a higher dice score. " + player1.getName() + " goes first. \n\nType 'start' to begin the game");
            Game.currentPlayer = true;
        } else if(window.dice1.getDiceP1Total() == window.dice2.getDiceP2Total()) {
            window.dice1.rerollPlayer1Dice();
            window.dice2.rerollPlayer2Dice();
            setFirstTurn(window);
        } else {
            window.infoLabel.append("\nPlayer 2 rolled a higher dice score. " + player2.getName() + " goes first. \n\nType 'start' to begin the game");
            Game.currentPlayer = false;
        }
    }

    //Handler for catching events. We'll catch strings, find their meaning then convert them to actual appendages using if statements.
    public void appendText(String text, Window window) {
        if (text.equalsIgnoreCase("quit")) {
            catchQuit();
        }

        //game happening for start
        if (text.equalsIgnoreCase("start")) {
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is now your turn " + player1.getName() + ".");
                window.dice1.rerollPlayer1Dice();
                window.infoLabel.append(window.dice1.getDice1());
            }else {
                window.infoLabel.append("\n\nIt is now your turn " + player2.getName() + ".");
                window.dice2.rerollPlayer2Dice();
                window.infoLabel.append(window.dice2.getDice2());
            }
        }

        //Turn handler activated when next
        if (text.equalsIgnoreCase("next")) {
            Game.currentPlayer = !Game.currentPlayer;
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is now your turn " + player1.getName() + ".");
                window.dice1.rerollPlayer1Dice();
                window.infoLabel.append(window.dice1.getDice1());
            }else {
                window.infoLabel.append("\n\nIt is now your turn " + player2.getName() + ".");
                window.dice2.rerollPlayer2Dice();
                window.infoLabel.append(window.dice2.getDice2());
            }
        } else {
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

            /* The following barrage of if and else statements is a result of our method of using an array
            of points. For player 2, we need to convert their input to match the array, because for the array, 0
            is at the bottom right of the board, while for player 2, 0 is at the top right of the board.
             */
            if(Game.currentPlayer) {
                if (Game.pointList[point1].getCount() == 0) {
                    window.infoLabel.append("\nThere is no checker on the starting point.");
                }
                else {
                    window.drawing.move(Game.pointList[point1], Game.pointList[point2]);
                }
            }
            else {
                if(point1<24&&point2<24) {
                    if (Game.pointList[23 - point1].getCount() == 0) {
                        window.infoLabel.append("\nThere is no checker on the starting point.");
                    } else {
                        window.drawing.move(Game.pointList[23 - point1], Game.pointList[23 - point2]);
                    }
                }
                if(point1<24&&point2==27) {
                    if (Game.pointList[23 - point1].getCount() == 0) {
                        window.infoLabel.append("\nThere is no checker on the starting point.");
                    } else {
                        window.drawing.move(Game.pointList[23 - point1], Game.pointList[point2]);
                    }
                }
                if(point1==25&&point2<24) {
                    if (Game.pointList[point1].getCount() == 0) {
                        window.infoLabel.append("\nThere is no checker on the starting point.");
                    } else {
                        window.drawing.move(Game.pointList[point1], Game.pointList[23-point2]);
                    }
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
