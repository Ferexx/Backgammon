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
        }

        //Turn handler activated when next
        if (text.equalsIgnoreCase("next")) {
            nextPlayer(window);
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

        if (text.equalsIgnoreCase("quit")) {
            catchQuit();
        }

        /* Main user input section, first seeing if they input a
        move using numbers, if not we go to text input. */
        try {
            Scanner sc = new Scanner(text);
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            sc.close();
            Moves.isValidMove(window, point1, point2);

        } catch (InputMismatchException e) {
            Scanner sc = new Scanner(text);
            char letter = sc.next().charAt(0);
            if(text.length() > 1) {
                System.out.println("Text input");
            }
            else if (Character.toString(letter).matches("[A-Za-z]{1}")) {
                try {
                    window.drawing.move(Game.pointList[Moves.getFromMove(letter)], Game.pointList[Moves.getToMove(letter)]);
                }
                catch (ArrayIndexOutOfBoundsException ee) {
                    window.infoLabel.append("\nThat is not a valid input.");
                }
            }
            else if(text.toUpperCase().contains("BAR"))
            {
                //Moves.isValidMove(window, BAR?, point2);
            }

            else if(text.toUpperCase().contains("BEAR"))
            {
                //Moves.isValidMove(window, point1, BEAR);
            }
        }
    }

    //Function to move the game on to the next player's turn.
    public static void nextPlayer(Window window) {
        do {
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
        window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Cobwag.\n");
    }

    //Quits
    private void catchQuit() {
        System.exit(0);
    }
}
