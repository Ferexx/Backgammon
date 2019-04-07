import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class commandHandler {

    //Making these static as we may want to access these from anywhere in the game. Adding them to commandHandler as I feel they are relevant to this class.
    public static final Player player1 = new Player();
    public static final Player player2 = new Player();
    public static boolean playerRolled = false;
    public static int finalScore;
    static JFrame invisi;

    //Initial setup for game, welcoming players
    public static void setNames(Window window) {
        player1.setChecker("Red");
        player2.setChecker("Black");
        window.infoLabel.append("\nWelcome to the game " + player1.getName() + ". You are player 1, and your dice are on top. Your colour is " + player1.getColour().toLowerCase() + ".\n");
        window.infoLabel.append("\nWelcome to the game " + player2.getName() + ". You are player 2, and your dice are on the bottom. Your colour is " + player2.getColour().toLowerCase() + ".\n");
        window.infoLabel.append("\nWE HIGHLY RECOMMEND TO READ THE HELP DOCUMENTATION BEFORE STARTING.\n");
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
        //Game happening for start
        if (text.equalsIgnoreCase("start")) {
            window.timer.threadStart(window);
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is your turn " + player1.getName() + ". ");
                rollDice(window);
            } else {
                window.infoLabel.append("\n\nIt is your turn " + player2.getName() + ". ");
                rollDice(window);
            }
            window.drawing.update();
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
            window.infoLabel.append("\nCheats have been enabled");
            //initialised the cheat positions
            Game.cheatPoints();
            Game.currentPlayer = !Game.currentPlayer;
            nextPlayer(window);
            //updates the board
            window.drawing.update();
            return;
        }

        //Exit the game
        if (text.equalsIgnoreCase("quit")) {
            catchQuit();
        }

        //Roll dice
        if(text.equalsIgnoreCase("roll")) {
            rollDice(window);
            playerRolled=true;
            return;
        }

        //Doubling cube
        if(text.equalsIgnoreCase("double")) {
            if (!playerRolled && ((Game.currentPlayer && DoublingCube.playerDoubling == 1) || (!Game.currentPlayer && DoublingCube.playerDoubling == 2) || DoublingCube.playerDoubling == 0)) {
                int response = JOptionPane.showConfirmDialog(null, "Double?", "Doubling Cube", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    DoublingCube.doubleCube();
                    if (Game.currentPlayer) DoublingCube.playerDoubling = 2;
                    else DoublingCube.playerDoubling = 1;
                    window.drawing.update();
                } else if (response == JOptionPane.NO_OPTION) {
                    if (Game.currentPlayer) player1.setScore(player1.getScore()+1);
                    else player2.setScore(player2.getScore()+1);
                    restartGame(window);
                }
            } else window.infoLabel.append("\nYou cannot offer the doubling cube at the moment.");
            return;
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
        else if (isNumeric(parsedInput[0]) && parsedInput[1].equalsIgnoreCase("OFF")) {
            if (Game.currentPlayer) {
                Moves.isValidMove(window, Integer.parseInt(parsedInput[0]), 27);
            } else {
                Moves.isValidMove(window, Integer.parseInt(parsedInput[0]), 26);
            }
        }
        //If the user is making a bar move
        else if (parsedInput[0].equalsIgnoreCase("BAR") && isNumeric(parsedInput[1])) {
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
        } else {
            window.infoLabel.append("\nInvalid input syntax, please try again.");
        }
    }

    //Function to move the game on to the next player's turn.
    public static void nextPlayer(Window window) {
        do {
            Moves.dice1Used=false;
            Moves.dice2Used=false;
            Game.currentPlayer = !Game.currentPlayer;
            if (Game.currentPlayer) {
                window.infoLabel.append("\n\nIt is now your turn " + player1.getName() + ". ");
                rollDice(window);
            } else {
                window.infoLabel.append("\n\nIt is now your turn " + player2.getName() + ". ");
                rollDice(window);
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

    public static void rollDice(Window window) {
        if(Game.currentPlayer) {
            window.infoLabel.append("Your rolls are " + window.p1D1.roll() + " and " + window.p1D2.roll());
            checkDoubles(window);
        }
        else {
            window.infoLabel.append("Your rolls are " + window.p2D1.roll() + " and " + window.p2D2.roll());
            checkDoubles(window);
        }
    }

    //Used for restarting the game
    public static void restartText(Window window) {
        window.infoLabel.setText(null);
        window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Cobwag.\n");
    }
    public static void restartGame(Window window) {
        invisi.dispose();
        Game.initPoints();
        restartText(window);
        DoublingCube.playerDoubling=0;
        window.timer.counter = 0;
        setNames(window);
        window.drawing.update();
    }

    //Quits
    private void catchQuit() {
        System.exit(0);
    }

    public static void checkWin(Window window) {
        if (Game.pointList[26].getCount() == 15 || Game.pointList[27].getCount() == 15) {
            //If player 1 wins
            if (Game.pointList[27].getCount() == 15) {
                if(Game.pointList[26].getCount()>0) {
                    player1.setScore(player1.getScore() + DoublingCube.doublingCube);
                }
                else {
                    boolean check = false;
                    for(int i = 18;i<24;i++) {
                        if(Game.pointList[i].getColor()=="Black"||Game.pointList[25].getCount()>0) {
                            player1.setScore(player1.getScore()+(DoublingCube.doublingCube*3));
                            check = true;
                            break;
                        }
                    }
                    if(!check) player1.setScore(player1.getScore()+(DoublingCube.doublingCube*2));
                }
            }

            //If player 2 wins
            if (Game.pointList[26].getCount() == 15) {
                if(Game.pointList[27].getCount()>0) {
                    player2.setScore(player2.getScore() + DoublingCube.doublingCube);
                }
                else {
                    boolean check = false;
                    for(int i = 0;i<6;i++) {
                        if(Game.pointList[i].getColor()=="Black"||Game.pointList[24].getCount()>0) {
                            player2.setScore(player2.getScore()+(DoublingCube.doublingCube*3));
                            check = true;
                            break;
                        }
                    }
                    if(!check) player2.setScore(player2.getScore()+(DoublingCube.doublingCube*2));
                }
            }
            Moves.totalMoves=0;

            window.infoLabel.append("\nGame over. Press any key to start the next game.");
            invisi = new JFrame();
            invisi.setResizable(false);
            invisi.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            invisi.setAlwaysOnTop(true);
            invisi.setUndecorated(true);
            invisi.setSize(300,200);
            invisi.setLocationRelativeTo(null);
            invisi.setOpacity(0.0f);
            invisi.setVisible(true);

            KeyListener keys = new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    restartGame(window);
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            };

            invisi.requestFocus();

            invisi.addKeyListener(keys);

            if(player1.getScore()>=finalScore||player2.getScore()>=finalScore) {

                if (player1.getScore() >= finalScore) {
                    JOptionPane.showMessageDialog(null, player1.getName() + " wins the game!");
                }
                if (player2.getScore() >= finalScore) {
                    JOptionPane.showMessageDialog(null, player2.getName() + " wins the game!");
                }
                //Confirmation dialog box for a yes or no
                int response = JOptionPane.showConfirmDialog(null, "Play again?", "Winner!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                //If they don't want to play again, we clear the text field (so their eyes are drawn to it) and then print that we are exiting. We then exit the program 2 seconds later.
                if (response == JOptionPane.NO_OPTION) {
                    window.infoLabel.setText("Exiting...");
                    System.exit(0);
                }

                //If the user says yes, we create a new game
                else if (response == JOptionPane.YES_OPTION) {
                    player1.setScore(0);
                    player2.setScore(0);
                    restartGame(window);
                    window.frame.dispose();
                    Game game = new Game();
                }
                else if (Game.currentPlayer) JOptionPane.showMessageDialog(null, player1.getName() + " wins the match!");
                else JOptionPane.showMessageDialog(null, player2.getName() + " wins the match!");
            }
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

    public static void checkDoubles(Window window) {
        if(Game.currentPlayer) {
            if(window.p1D1.getRoll()==window.p1D2.getRoll()) {
                window.infoLabel.append("\nDice rolls are equal. Values will be doubled");
                window.p1D1.doubleRoll();
                window.p1D2.doubleRoll();
            }
        }
        else {
            if(window.p2D1.getRoll()==window.p2D2.getRoll()) {
                window.infoLabel.append("\nDice rolls are equal. Values will be doubled");
                window.p2D1.doubleRoll();
                window.p2D2.doubleRoll();
            }
        }
    }
}
