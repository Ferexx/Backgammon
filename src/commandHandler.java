import javax.swing.*;

class commandHandler {

    //Making these static as we may want to access these from anywhere in the game. Adding them to commandHandler as I feel they are relevant to this class.
    public static final Player player1 = new Player();
    public static final Player player2 = new Player();

    //Initial setup for game, welcoming players
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

        if ((window.p1D1.getRoll() + window.p1D2.getRoll()) > (window.p2D1.getRoll() + window.p2D2.getRoll())) {
            window.infoLabel.append("\nPlayer 1 rolled a higher dice score. " + player1.getName() + " goes first. \n\nType 'start' to begin the game");
            Game.currentPlayer = true;
        } else if ((window.p1D1.getRoll() + window.p1D2.getRoll()) == (window.p2D1.getRoll() + window.p2D2.getRoll())) {
            window.infoLabel.append("\nDice Rolls are equal. Re-rolling");
            setFirstTurn(window);
        } else {
            window.infoLabel.append("\nPlayer 2 rolled a higher dice score. " + player2.getName() + " goes first. \n\nType 'start' to begin the game");
            Game.currentPlayer = false;
        }
    }

    //Takes in the user-input text then checks against a variety of possible commands
    public void appendText(String text, Window window) {
        int dice1, dice2;
        //Game happening for start
        if (text.equalsIgnoreCase("start")) {
            window.infoLabel.append("\nPlease input moves as either a single character, or two numbers separated by a space, with the first number being the point you wish to move a checker from, and the second being the point you wish to move a checker to. In the case of a bar move, enter \"BAR\" followed by the point you wish to move to, separated by a space. In the case of bearing off, please enter the point you wish to move a checker from, followed by \"OFF\", again separated by a space.");
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is your turn " + player1.getName() + ". ");
                window.p1D1.roll();
                window.p1D2.roll();
                dice1 = window.p1D1.getRoll();
                dice2 = window.p1D2.getRoll();
                window.infoLabel.append("Your dice rolls are " + dice1 + " and " + dice2);
            } else {
                window.p1D1.roll();
                window.p1D2.roll();
                dice1 = window.p2D1.getRoll();
                dice2 = window.p2D2.getRoll();
                window.infoLabel.append("Your rolls are " + dice1 + " and " + dice2);
            }
            window.drawing.update();
            checkDoubles(window, dice1, dice2);
            Moves.possibleMoves(window);
            return;
        }

        //Moving to the next player's turn
        if (text.equalsIgnoreCase("next")) {
            nextPlayer(window);
            return;
        } else {
            window.infoLabel.append("\n" + text);
        }

        //Cheat command, sets all checkers to points given in assignment
        if (text.equalsIgnoreCase("cheat")) {
            window.infoLabel.append("\nCheats have been enabled\n\n");
            //initialised the cheat positions
            Game.cheatPoints();
            //updates the board
            window.drawing.update();
            return;
        }

        //Exit the game
        if (text.equalsIgnoreCase("quit")) {
            catchQuit();
        }

        /* Main user input section, parsing input using whitespace as a delimiter, then checking the parsed strings
         * for appropriate values */
        String delim = "[ ]+";
        String[] parsedInput = text.split(delim);
        if (parsedInput.length > 2) {
            window.infoLabel.append("\nThat is not a valid input.");
            return;
        }
        //If the user is inputting numeric values to move checkers
        if (isNumeric(parsedInput[0]) && isNumeric(parsedInput[1])) {
            Moves.isValidMove(window, Integer.parseInt(parsedInput[0]), Integer.parseInt(parsedInput[1]));
        }
        //If the user is making a bear-off move
        else if (isNumeric(parsedInput[0]) && parsedInput[1].equals("OFF")) {
            if (Game.currentPlayer) {
                Moves.isValidMove(window, Integer.parseInt(parsedInput[0]), 27);
            } else {
                Moves.isValidMove(window, Integer.parseInt(parsedInput[0]), 26);
            }
        }
        //If the user is making a bar move
        else if (parsedInput[0].equals("BAR") && isNumeric(parsedInput[1])) {
            if (Game.currentPlayer) {
                Moves.isValidMove(window, 24, Integer.parseInt(parsedInput[1]));
            } else {
                Moves.isValidMove(window, 25, Integer.parseInt(parsedInput[1]));
            }
        }
        //If the user is using letters to move checkers
        else if (parsedInput[0].length() == 1) {
            char[] letter = parsedInput[0].toCharArray();
            Moves.totalMoves++;
            window.drawing.move(Game.pointList[Moves.getFromMove(letter[0])], Game.pointList[Moves.getToMove(letter[0])]);
            if (Moves.totalMoves == 2) nextPlayer(window);
        }
        else if (parsedInput[0].equalsIgnoreCase("double")) {
            if (Moves.totalMoves == 0 && ((Game.currentPlayer && DoublingCube.playerDoubling == 1) || (!Game.currentPlayer && DoublingCube.playerDoubling == 2) || DoublingCube.playerDoubling == 0)) {
                int response = JOptionPane.showConfirmDialog(null, "Double?", "Doubling Cube", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    DoublingCube.doubleCube();
                    if (Game.currentPlayer) DoublingCube.playerDoubling = 2;
                    else DoublingCube.playerDoubling = 1;
                    window.drawing.update();
                } else if (response == JOptionPane.NO_OPTION) {
                    if (Game.currentPlayer) Game.matchList[Match.currentMatch].setPlayerWon(1);
                    else Game.matchList[Match.currentMatch].setPlayerWon(2);
                    Game.matchList[Match.currentMatch].setMatchValue(DoublingCube.doublingCube);
                    Game.initPoints();
                    window.infoLabel.setText("\"Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Conway.\"\n");
                    Match.currentMatch++;
                    DoublingCube.playerDoubling = 0;
                    setNames(window);
                    window.drawing.update();
                }
            } else window.infoLabel.append("\nYou cannot offer the doubling cube at the moment.");
        } else {
            window.infoLabel.append("\nInvalid input syntax, please try again.");
        }
    }

    //Function to move the game on to the next player's turn.
    public static void nextPlayer(Window window) {
        int dice1, dice2;
        do {
            Game.currentPlayer = !Game.currentPlayer;
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is now your turn " + player1.getName() + ". ");
                window.p1D1.roll();
                window.p1D2.roll();
                dice1 = window.p1D1.getRoll();
                dice2 = window.p1D2.getRoll();
                window.infoLabel.append("Your rolls are " + dice1 + " and " + dice2);
                checkDoubles(window, dice1, dice2);
            } else {
                window.infoLabel.append("\n\nIt is now your turn " + player2.getName() + ". ");
                window.p2D1.roll();
                window.p2D2.roll();
                dice1 = window.p2D1.getRoll();
                dice2 = window.p2D2.getRoll();
                window.infoLabel.append("Your rolls are " + dice1 + " and " + dice2);
                checkDoubles(window, dice1, dice2);
            }
            window.drawing.update();
            Moves.possibleMoves(window);
            if (Moves.movesList.isEmpty()) {
                window.infoLabel.append("\nYou have no possible moves. Skipping turn.");
            }
            if (Moves.movesList.size() == 1) {
                window.infoLabel.append("\nYou have only one possible move, automatically performing this move and moving to next players turn.");
                window.drawing.move(Game.pointList[Moves.getFromMove('A')], Game.pointList[Moves.getToMove('A')]);
            }

        } while (Moves.movesList.size() < 2);
        Moves.totalMoves = 0;
    }

    //Used for restarting the game
    public static void restartText(Window window) {
        window.infoLabel.setText(null);
        window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Conway.\n");
    }

    //Quits
    private void catchQuit() {
        System.exit(0);
    }

    public static void checkWin(Window window) {
        //Making this static in case we want to reference this method from anywhere. We're using a check to see if ANYONE has won, and then we can change behaviour accordingly.
        if (Game.pointList[26].getCount() == 15 || Game.pointList[27].getCount() == 15) {
            //If player 1 wins
            if (Game.pointList[27].getCount() == 15) {
                Game.matchList[Match.currentMatch].setPlayerWon(1);
                Game.initPoints();
                restartText(window);
                setNames(window);
            }

            //If player 2 wins
            if (Game.pointList[26].getCount() == 15) {
                Game.matchList[Match.currentMatch].setPlayerWon(2);
                Game.initPoints();
                restartText(window);
                setNames(window);
            }
            Match.currentMatch++;
            Moves.totalMoves=0;

            int player1count = 0, player2count = 0;
            for (int i = 0; i < Match.numberOfMatches; i++) {
                if (Game.matchList[i].getPlayerWon() == 1) {
                    player1count += Game.matchList[i].getMatchValue();
                }
                if (Game.matchList[i].getPlayerWon() == 2) {
                    player2count += Game.matchList[i].getMatchValue();
                }
            }
            if (Match.currentMatch==Match.numberOfMatches) {
                if(player1count>player2count) JOptionPane.showMessageDialog(null, player1.getName() + " wins the game!");
                if(player2count>player1count) JOptionPane.showMessageDialog(null, player2.getName() + " wins the game!");
                else JOptionPane.showMessageDialog(null, "Draw!");

                //Confirmation dialog box for a yes or no
                int response = JOptionPane.showConfirmDialog(null, "Play again?", "Winner!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                //If they don't want to play again, we clear the text field (so their eyes are drawn to it) and then print that we are exiting. We then exit the program 2 seconds later.
                if (response == JOptionPane.NO_OPTION) {
                    window.infoLabel.setText("Exiting...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.exit(0);
                }

                //If the user says yes, we re-initiate the points and begin again.
                else if (response == JOptionPane.YES_OPTION) {
                    restartText(window);
                    Game.initPoints();
                    window.drawing.update();
                    setNames(window);
                }
            }
            else if(Game.currentPlayer) JOptionPane.showMessageDialog(null, player1.getName() + " wins the match!");
            else JOptionPane.showMessageDialog(null, player2.getName() + " wins the match!");
    }
}

    //Small function to check if a string is a single digit
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static void checkDoubles(Window window, int dice1, int dice2) {
        if(dice1 == dice2) {
            window.infoLabel.append("Dice rolls are equal. Values will be doubled\n");
            doubles(window, dice1, dice2);
            Game.currentPlayer = !Game.currentPlayer;
            Moves.totalMoves=0;
        } else {
            return;
        }
    }

    public static void doubles(Window window, int dice1, int dice2) {

        window.infoLabel.append("Doing double things here haha don't mind me\n");

    }
}
