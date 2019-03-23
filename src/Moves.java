import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

class Moves {

    /*Basic checking for when user inputs via numbers (e.g. 0 3), catches any errors that
    * may occur with input*/
    private static int totalMoves;
    public static void isValidMove(Window window, int from, int to) {
        //If the player inputs an invalid letter for text input
        if(from==-1||to==-1) {
            window.infoLabel.append("\nThat is not a valid input.");
            return;
        }
        //If the input is not within the bounds of the board
        if(from > 27 || to > 27 || from < 0 || to < 0) {
            window.infoLabel.append("\nYour move is out of bounds.");
            return;
        }
        //If a player tries to move onto the bar
        if(to==24||to==25) {
            window.infoLabel.append("\nYou cannot move onto the bar.");
            return;
        }
        //If a player tries to move from bear-off
        if(from==26||from==27) {
            window.infoLabel.append("\nYou cannot move from bear-off");
            return;
        }
        //If the player tries to move the wrong way around the board
        if(to<from) {
            window.infoLabel.append("\nYou cannot move backwards.");
            return;
        }
        //Specific to player 1
        if(Game.currentPlayer) {
            //If a player tries to move a certain amount not allowed by their dice rolls
            if(to-from!=window.p1D1.getRoll()&&to-from!=window.p1D2.getRoll()&&to-from!=window.p1D1.getRoll()+window.p1D2.getRoll()) {
                window.infoLabel.append("\nYour move does not match the dice rolls.");
                return;
            }
            //If a player tries to move from a point with no checker on it
            if (Game.pointList[from].getCount() == 0) {
                window.infoLabel.append("\nThere is no checker on the starting point.");
                return;
            }
            //If a player tries to move from a point controlled by the opposing player
            if(Game.pointList[from].getColor()=="Black") {
                window.infoLabel.append("\nYou cannot move opponents checkers.");
                return;
            }
            //If a player tries to move to a point controlled by the opposing player
            if(Game.pointList[to].getColor()=="Black"&&Game.pointList[to].getCount()>1) {
                window.infoLabel.append("\nYou cannot move to a point controlled by your opponent.");
                return;
            }
            totalMoves++;
            window.drawing.move(Game.pointList[from], Game.pointList[to]);
        }
        //Specific to player 2
        else {
            //If a player tries to move a certain amount not allowed by their dice rolls
            if(to-from!=window.p2D1.getRoll()&&to-from!=window.p2D2.getRoll()&&to-from!=window.p2D1.getRoll()+window.p2D2.getRoll()) {
                window.infoLabel.append("\nYour move does not match the dice rolls.");
                return;
            }
            //If a player tries to move from a point with no checker on it
            if (Game.pointList[from].getCount() == 0) {
                window.infoLabel.append("\nThere is no checker on the starting point.");
                return;
            }
            //If a player tries to move from a point controlled by the opposing player
            if(Game.pointList[from].getColor()=="Red") {
                window.infoLabel.append("\nYou cannot move opponents checkers.");
                return;
            }
            //If a player tries to move to a point controlled by the opposing player
            if(Game.pointList[to].getColor()=="Red"&&Game.pointList[to].getCount()>1) {
                window.infoLabel.append("\nYou cannot move to a point controlled by your opponent.");
                return;
            }
            totalMoves++;
            window.drawing.move(Game.pointList[from], Game.pointList[to]);
        }
        //Go to next turn if the move uses both dice
        if(Game.currentPlayer) {
            if(to-from>window.p1D1.getRoll()&&to-from>window.p1D2.getRoll()&&window.p1D1.getRoll()!=window.p1D2.getRoll()) {
                commandHandler.nextPlayer(window);
                return;
            }
        }
        else {
            if(to-from>window.p2D1.getRoll()&&to-from>window.p2D2.getRoll()&&window.p2D1.getRoll()!=window.p2D2.getRoll()) {
                commandHandler.nextPlayer(window);
                return;
            }
        }
        //Only allow a player to make a maximum of two moves per turn
        if(totalMoves==2) commandHandler.nextPlayer(window);
    }


    public static final ArrayList<Map.Entry<Integer, Integer>> movesList = new ArrayList<>();
    public static int getFromMove(char input) {
        int a = input-65;
        if (a>=movesList.size()) {
            return -1;
        }
        return movesList.get(a).getKey();
    }
    public static int getToMove(char input) {
        int a = input-65;
        if (a>=movesList.size()) {
            return -1;
        }
        return movesList.get(a).getValue();
    }


    /*This thing looks like a mess, but is actually fairly well-structured. There are two main parts to it, which
    * are in essence identical, one for each player. The only difference between the two parts is the first part
    * adds the dice count to i, whereas the second part subtracts it. This is because one player needs to move
    * clockwise around the board, while the second player moves anticlockwise.
    * First, the function checks for any moves from the bar, then checks for regular moves on the board. Finally,
    * it checks if a bear off is possible (all checkers are in the homeboard).
    * For each move checking, the function checks for a move first with die 1, then die 2, and finally die 1 and
    * die 2 added together.
    * When a valid move is found, it is printed to the info box, then added to the ArrayList.*/
    public static void possibleMoves(Window window) {
        movesList.clear();
        window.infoLabel.append("\nYour possible moves are:\n");
        int dice1, dice2;
        if(Game.currentPlayer) {
            System.out.print("Player 1 moves: ");
            dice1 = window.p1D1.getRoll();
            dice2 = window.p1D2.getRoll();

            //Moves for first player
            //Bar moves
            if (Game.pointList[24].getCount() != 0) {
                if (Game.pointList[dice1-1].getCount() == 0 || Game.pointList[dice1-1].getColor()=="Red") {
                    window.infoLabel.append("BAR-" + (dice1 - 1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24, dice1-1));
                }
                if (Game.pointList[dice2-1].getCount() == 0 || Game.pointList[dice2-1].getColor()=="Red") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + (dice2 - 1) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(24, dice2-1));
                    }
                }
                if(Game.pointList[dice1+dice2-1].getCount() == 0 || Game.pointList[dice1+dice2-1].getColor()=="Red") {
                    window.infoLabel.append("BAR-"+ (dice1 + dice2 - 1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24,dice1+dice2-1));
                }
                if (Game.pointList[dice1-1].getCount() == 1 && Game.pointList[dice1-1].getColor()=="Black") {
                    window.infoLabel.append("BAR-" + (dice1 - 1) + "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24, dice1-1));
                }
                if (Game.pointList[dice2-1].getCount() == 1 && Game.pointList[dice2-1].getColor()=="Black") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + (dice2 - 1) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(24, dice2-1));
                    }
                }
                if(Game.pointList[dice1+dice2-1].getCount() == 1 && Game.pointList[dice1+dice2-1].getColor()=="Black") {
                    window.infoLabel.append("BAR-"+ (dice1 + dice2 - 1) + "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24,dice1+dice2-1));
                }
            }

            //Regular moves
            for (int i = 0; i < 24; i++) {
                if (Game.pointList[i].getColor() == "Red" && Game.pointList[i].getCount() != 0) {
                    if (i+dice1<24&&(Game.pointList[i + dice1].getCount() == 0 || Game.pointList[i + dice1].getColor() == "Red")) {
                        window.infoLabel.append(i + "-" + (i + dice1) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1));
                    }
                    if (i+dice2<24&&(Game.pointList[i + dice2].getCount() == 0 || Game.pointList[i + dice2].getColor() == "Red")) {
                        if (dice1 != dice2) {
                            window.infoLabel.append(i + "-" + (i + dice2) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice2));
                        }
                    }
                    if (i+dice1+dice2<24&&(Game.pointList[i + dice1 + dice2].getCount() == 0 || Game.pointList[i + dice1 + dice2].getColor() == "Red")) {
                        window.infoLabel.append(i + "-" + (i + dice1 + dice2) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1 + dice2));
                    }
                    if (i+dice1<24&&(Game.pointList[i + dice1].getColor() == "Black" && Game.pointList[i + dice1].getCount() == 1)) {
                        window.infoLabel.append(i + "-" + (i + dice1) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1));
                    }
                    if (i+dice2<24&&(Game.pointList[i + dice2].getColor() == "Black" && Game.pointList[i + dice2].getCount() == 1)) {
                        if (dice1 != dice2) {
                            window.infoLabel.append(i + "=" + (i + dice2) + "*\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice2));
                        }
                    }
                    if (i+dice1+dice2<24&&(Game.pointList[i + dice1 + dice2].getColor() == "Black" && Game.pointList[i + dice1 + dice2].getCount() == 1)) {
                        window.infoLabel.append(i + "-" + (i + dice1 + dice2) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1 + dice2));
                    }
                }
                else {
                    //Bear-off moves
                    if (checkBearOffPossible()) {
                        if ((i + dice1) > 23) {
                            window.infoLabel.append(i + "-OFF\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, 27));
                        }
                        if ((i + dice2) > 23 && dice1 != dice2) {
                            window.infoLabel.append(i + "-OFF\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, 27));
                        }
                        if(i+dice1+dice2>23) {
                            window.infoLabel.append(i+"-OFF\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i,27));
                        }
                    }
                }
            }
        }

        //Moves for second player
        else {
            System.out.print("Player 2 moves: ");
            dice1 = window.p2D1.getRoll();
            dice2 = window.p2D2.getRoll();
            //Bar moves
            if (Game.pointList[25].getCount() != 0) {
                if (Game.pointList[24 - dice1].getCount() == 0 || Game.pointList[24 - dice1].getColor()=="Black") {
                    window.infoLabel.append("BAR-" + (dice1 - 1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice1));
                }
                if (Game.pointList[24 - dice2].getCount() == 0 || Game.pointList[24 - dice2].getColor()=="Black") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + (dice2 - 1) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice2));
                    }
                }
                if(Game.pointList[24-dice1-dice2].getCount() == 0 || Game.pointList[24-dice1-dice2].getColor()=="Black") {
                    window.infoLabel.append("BAR-" + (dice1 + dice2 - 1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25,24-dice1-dice2));
                }
                if (Game.pointList[24 - dice1].getCount() == 1 && Game.pointList[24 - dice1].getColor()=="Red") {
                    window.infoLabel.append("BAR-" + (dice1 - 1) + "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice1));
                }
                if (Game.pointList[24 - dice2].getCount() == 1 && Game.pointList[24 - dice2].getColor()=="Red") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + (dice2 - 1) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice2));
                    }
                }
                if(Game.pointList[24-dice1-dice2].getCount() == 1 && Game.pointList[24-dice1-dice2].getColor()=="Red") {
                    window.infoLabel.append("BAR-" + (dice1 + dice2 - 1) + "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25,24-dice1-dice2));
                }
            }

            //Regular moves
            for (int i = 23; i >= 0; i--) {
                if (Game.pointList[i].getColor() == "Black" && Game.pointList[i].getCount() != 0) {
                    //Standard move
                    if (i-dice1>=0&&(Game.pointList[i - dice1].getCount() == 0 || Game.pointList[i - dice1].getColor() == "Black")) {
                            window.infoLabel.append((23 - i) + "-" + (23 - i + dice1) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1));
                    }
                    if (i-dice2>=0&&(Game.pointList[i - dice2].getCount() == 0 || Game.pointList[i - dice2].getColor() == "Black")) {
                        if (dice1 != dice2) {
                            window.infoLabel.append((23 - i) + "-" + (23 - i + dice2) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice2));
                        }
                    }
                    if (i-dice1-dice2>=0&&(Game.pointList[i - dice1 - dice2].getCount() == 0 || Game.pointList[i - dice1 - dice2].getColor() == "Black")) {
                        window.infoLabel.append((23 - i) + "-" + (23 - i + dice1 + dice2) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1 - dice2));
                    }
                    //Move and capture point
                    if (i-dice1>=0&&(Game.pointList[i - dice1].getColor() == "Red" && Game.pointList[i - dice1].getCount() == 1)) {
                        window.infoLabel.append((23 - i) + "-" + (23 - i + dice1) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1));
                    }
                    if (i-dice2>=0&&(Game.pointList[i - dice2].getColor() == "Red" && Game.pointList[i - dice2].getCount() == 1 && dice1 != dice2)) {
                        window.infoLabel.append((23 - i) + "-" + (23 - i + dice2) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice2));
                    }
                    if (i-dice1-dice2>=0&&(Game.pointList[i - dice1 - dice2].getColor() == "Red" && Game.pointList[i - dice1 - dice2].getCount() == 1)) {
                        window.infoLabel.append((23 - i) + "-" + (23 - i + dice1 + dice2) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1 - dice2));
                    }
                }
                else {
                    //Bear-off moves
                    if (checkBearOffPossible()) {
                        if ((i - dice1) < 0) {
                            window.infoLabel.append(23 - i + "-OFF\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, 26));
                        }
                        if ((i - dice2) < 0 && dice1 != dice2) {
                            window.infoLabel.append(23 - i + "-OFF\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, 26));
                        }
                        if(i-dice1-dice2<0) {
                            window.infoLabel.append(23-i+"-OFF\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, 26));
                        }
                    }
                }
            }
        }
        System.out.println(movesList.toString()+" Number of possible moves: "+movesList.size());
    }


    //Checks if all checkers are on the homeboard
    private static Boolean checkBearOffPossible() {
        if(Game.currentPlayer) {
            for (int i = 0; i < 18; i++) {
                if (Game.pointList[i].getColor()=="Red") {
                    return false;
                }
            }
            return Game.pointList[24].getColor() != "Red";
        } else {
            for (int i = 23; i > 5; i--) {
                if (Game.pointList[i].getColor()=="Black") {
                    return false;
                }
            }
            return Game.pointList[25].getColor() != "Black";
        }
    }
}