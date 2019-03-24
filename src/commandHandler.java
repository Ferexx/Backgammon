import java.util.InputMismatchException;
import java.util.Scanner;

class commandHandler {

    //Making these static as we may want to access these from anywhere in the game. Adding them to commandHandler as I feel they are relevant to this class.
    public static final Player player1 = new Player();
    public static final Player player2 = new Player();

    public static void setNames(Window window) {
        player1.setChecker("Red");
        player2.setChecker("Black");
        window.infoLabel.append("\nWelcome to the game " + player1.getName() + ". You are player 1, and your dice are on top. Your colour is " + player1.getColour().toLowerCase() + ".\n");
        window.infoLabel.append("\nWelcome to the game " + player2.getName() + ". You are player 2, and your dice are on the bottom. Your colour is " + player2.getColour().toLowerCase() + ".\n");
        setFirstTurn(window);
    }

    //Rolling to decide who goes first
    private static void setFirstTurn(Window window) {

        window.p1D1.roll();
        window.p1D2.roll();
        window.infoLabel.append("\nPlayer 1 rolled: " + window.p1D1.getRoll() + " " + window.p1D2.getRoll());
        window.p2D1.roll();
        window.p2D2.roll();
        window.infoLabel.append("\nPlayer 2 rolled: " + window.p2D1.getRoll() + " " + window.p2D2.getRoll());

        if((window.p1D1.getRoll() + window.p1D2.getRoll()) > (window.p2D1.getRoll() + window.p2D2.getRoll())) {
            window.infoLabel.append("\nPlayer 1 rolled a higher dice score. " + player1.getName() + " goes first. \n\nType 'start' to begin the game");
            Game.currentPlayer = true;
        } else if( (window.p1D1.getRoll() + window.p1D2.getRoll()) == (window.p2D1.getRoll() + window.p2D2.getRoll())) {
            window.infoLabel.append("\nDice Rolls are equal. Re-rolling");
            setFirstTurn(window);
        } else {
            window.infoLabel.append("\nPlayer 2 rolled a higher dice score. " + player2.getName() + " goes first. \n\nType 'start' to begin the game");
            Game.currentPlayer = false;
        }
    }

    //Handler for catching events. We'll catch strings, find their meaning then convert them to actual appendages using if statements.
    public void appendText(String text, Window window) {

        //game happening for start
        if (text.equalsIgnoreCase("start")) {
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is your turn " + player1.getName() + ". ");
                window.p1D1.roll();
                window.p1D2.roll();
                window.infoLabel.append("Your rolls are " + window.p1D1.getRoll() + " and " + window.p1D2.getRoll());
            } else {
                window.infoLabel.append("\n\nIt is your turn " + player2.getName() + ". ");
                window.p2D1.roll();
                window.p2D2.roll();
                window.infoLabel.append("Your rolls are " + window.p2D1.getRoll() + " and " + window.p2D2.getRoll());
            }
            window.drawing.update();
            Moves.possibleMoves(window);
            return;
        }

        //Turn handler activated when next
        if (text.equalsIgnoreCase("next")) {
            nextPlayer(window);
            return;
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
            return;
        }

        if (text.equalsIgnoreCase("quit")) {
            catchQuit();
        }

        /* Main user input section, parsing using delimiter, then checking the parsed strings
         * for appropriate values */
        String delims = "[ ]+";
        String[] parsedInput = text.split(delims);
        if(parsedInput.length>2) {
            window.infoLabel.append("\nThat is not a valid input.");
            return;
        }
        if(isNumeric(parsedInput[0])&&isNumeric(parsedInput[1])) {
            Moves.isValidMove(window,Integer.parseInt(parsedInput[0]),Integer.parseInt(parsedInput[1]));
        }
        else if(isNumeric(parsedInput[0])&&parsedInput[1].equals("BEAR")) {
            if(Game.currentPlayer) {
                Moves.isValidMove(window, Integer.parseInt(parsedInput[0]), 27);
            }
            else {
                Moves.isValidMove(window, Integer.parseInt(parsedInput[0]), 26);
            }
        }
        else if(parsedInput[0].equals("BAR")&&isNumeric(parsedInput[1])) {
            if(Game.currentPlayer) {
                Moves.isValidMove(window, 24, Integer.parseInt(parsedInput[1]));
            }
            else {
                Moves.isValidMove(window, 25, Integer.parseInt(parsedInput[1]));
            }
        }
        else if(parsedInput[0].length()==1) {
            char[] letter = parsedInput[0].toCharArray();
            window.drawing.move(Game.pointList[Moves.getFromMove(letter[0])], Game.pointList[Moves.getToMove(letter[0])]);
        }
        else {
            window.infoLabel.append("Couldn't parse the input");
        }
    }

    //Function to move the game on to the next player's turn.
    public static void nextPlayer(Window window) {
        do {
            checkWin(window);
            Game.currentPlayer = !Game.currentPlayer;
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is now your turn " + player1.getName() + ". ");
                window.p1D1.roll();
                window.p1D2.roll();
                window.infoLabel.append("Your rolls are " + window.p1D1.getRoll() + " and " + window.p1D2.getRoll());
            } else {
                window.infoLabel.append("\n\nIt is now your turn " + player2.getName() + ". ");
                window.p2D1.roll();
                window.p2D2.roll();
                window.infoLabel.append("Your rolls are " + window.p2D1.getRoll() + " and " + window.p2D2.getRoll());
            }
            window.drawing.update();
            Moves.possibleMoves(window);
            if (Moves.movesList.isEmpty()) {
                window.infoLabel.append("\nYou have no possible moves. Skipping turn.");
            }
            if (Moves.movesList.size()==1) {
                window.infoLabel.append("\nYou have only one possible move, automatically performing this move and moving to next players turn.");
                window.drawing.move(Game.pointList[Moves.getFromMove('A')], Game.pointList[Moves.getToMove('A')]);
            }

        } while(Moves.movesList.size()<2);
    }

    //Used for restarting the game
    public void restartText(Window window) {
        window.infoLabel.setText(null);
        window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Conway.\n");
    }

    //Quits
    private void catchQuit() {
        System.exit(0);
    }

    private static void checkWin(Window window) {
        //Making this static in case we want to reference this method from anywhere. We're using a check to see if ANYONE has won, and then we can change behaviour accordingly.
        if(Game.pointList[26].getCount() == 15 || Game.pointList[27].getCount() == 15)
        {
            ///Black won
            //window.infoLabel.append("" + player1.getName() + " wins!");
        }
            //window.infoLabel.append("" + player2.getName() + " wins!");
}


    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
