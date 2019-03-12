import javax.swing.*;
import java.util.Scanner;

class commandHandler {

    //Making these static as we may want to access these from anywhere in the game. Adding them to commandHandler as I feel they are relevant to this class.
    public static Player player1 = new Player();
    public static Player player2 = new Player();
    public commandHandler() {

    }

    public static void setNames(Window window) {
        player1.setChecker("Red");
        player2.setChecker("Black");
        window.infoLabel.append("\nWelcome to the game " + player1.getName() + ". You are player 1, and your dice are on top. Your colour is " + player1.getColour().toLowerCase() + ".\n");
        window.infoLabel.append("\nWelcome to the game " + player2.getName() + ". You are player 2, and your dice are on the bottom. Your colour is " + player2.getColour().toLowerCase() + ".\n");
        setFirstTurn(window);
    }

    //Rolling to decide who goes first
    public static void setFirstTurn(Window window) {

        window.drawing.update();

        if((window.dice1_1.getDiceValue() + window.dice1_2.getDiceValue()) > (window.dice2_1.getDiceValue() + window.dice2_2.getDiceValue())) {
            window.infoLabel.append("\nPlayer 1 rolled a higher dice score. " + player1.getName() + " goes first. \n\nType 'start' to begin the game");
            Game.currentPlayer = true;
        } else if( (window.dice1_1.getDiceValue() + window.dice1_2.getDiceValue()) == (window.dice2_1.getDiceValue() + window.dice2_2.getDiceValue())) {
            window.dice1_1.rerollDice(window);
            window.dice1_2.rerollDice(window);
            window.dice2_1.rerollDice(window);
            window.dice2_2.rerollDice(window);
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
                window.dice1_1.rerollDice(window);
                window.dice1_2.rerollDice(window);
                window.infoLabel.append("Your rolls are " + window.dice1_1.getDiceValue() + " and " + window.dice1_2.getDiceValue());
            } else {
                window.infoLabel.append("\n\nIt is now your turn " + player2.getName() + ".");
                window.dice2_1.rerollDice(window);
                window.dice2_2.rerollDice(window);
                window.infoLabel.append("Your rolls are " + window.dice2_1.getDiceValue() + " and " + window.dice2_2.getDiceValue());
            }
            Moves.possibleMoves(window);
        }

        //Turn handler activated when next
        if (text.equalsIgnoreCase("next")) {
            Game.currentPlayer = !Game.currentPlayer;
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is now your turn " + player1.getName() + ".");
                window.dice1_1.rerollDice(window);
                window.dice1_2.rerollDice(window);
                window.infoLabel.append("Your rolls are " + window.dice1_1.getDiceValue() + " and " + window.dice1_2.getDiceValue());
            } else {
                window.infoLabel.append("\n\nIt is now your turn " + player2.getName() + ".");
                window.dice2_1.rerollDice(window);
                window.dice2_2.rerollDice(window);
                window.infoLabel.append("Your rolls are " + window.dice2_1.getDiceValue() + " and " + window.dice2_2.getDiceValue());
            }
            Moves.possibleMoves(window);
        } else {
            window.infoLabel.append("\n" + text);
        }

        //cheat command - sv_cheats 1
        //for testing
        if (text.equalsIgnoreCase("sv_cheats 1")) {
            window.infoLabel.append("\nCheats have been enabled\n\n");
            //initialised the cheat positions
            Game.cheatPoints();
            //updates the board
            window.drawing.update();
        }

        try {
            Scanner sc = new Scanner(text);
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            sc.close();

            Moves.isValidMove(window, point1, point2);
        } catch (NumberFormatException e) {
            e.printStackTrace();

            Scanner sc = new Scanner(text);
            String letter = sc.nextLine();
            if (letter.matches("[A-Za-z]{1}")) {
                switch(letter) {
                    case "A":
                        Moves.getFromMove('A');
                        break;

                    case "B":
                        Moves.getFromMove('B');
                        break;

                    case "C":
                        Moves.getFromMove('C');
                        break;

                    case "D":
                        Moves.getFromMove('D');
                        break;

                    case "E":
                        Moves.getFromMove('E');
                        break;

                    case "F":
                        Moves.getFromMove('F');
                        break;

                    case "G":
                        Moves.getFromMove('G');
                        break;
                }
            }

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
