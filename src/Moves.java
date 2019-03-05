import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class Moves {
    public static void isValidMove(Window window, int from, int to) {
        if(from > 25 || to > 27 || from < 0 || to < 0) {
            window.infoLabel.append("\nYour move is out of bounds.");
        }
        if(Game.currentPlayer) {
            if (Game.pointList[from].getCount() == 0) {
                window.infoLabel.append("\nThere is no checker on the starting point.");
            } else {
                window.drawing.move(Game.pointList[from], Game.pointList[to]);
            }
        } else {
            if(from<24&&to<24) {
                if (Game.pointList[23 - from].getCount() == 0) {
                    window.infoLabel.append("\nThere is no checker on the starting point.");
                } else {
                    window.drawing.move(Game.pointList[23 - from], Game.pointList[23 - to]);
                }
            }
            if(from<24&&to==27) {
                if (Game.pointList[23 - from].getCount() == 0) {
                    window.infoLabel.append("\nThere is no checker on the starting point.");
                } else {
                    window.drawing.move(Game.pointList[23 - from], Game.pointList[to]);
                }
            }
            if(from==25&&to<24) {
                if (Game.pointList[from].getCount() == 0) {
                    window.infoLabel.append("\nThere is no checker on the starting point.");
                } else {
                    window.drawing.move(Game.pointList[from], Game.pointList[23-to]);
                }
            }
        }
    }

    public static ArrayList<Map.Entry<Integer, Integer>> movesList = new ArrayList<>();

    //TODO: Add a case where a player can move a checker dice1+dice2 positions
    public static void possibleMoves(Window window) {
        window.infoLabel.append("\nYour possible moves are: ");
        int dice1, dice2;
        if(Game.currentPlayer) {
            dice1 = window.dice1.getDice1();
            dice2 = window.dice1.getDice2();
            //Bar moves
            if (Game.pointList[24].getCount() != 0) {
                if (Game.pointList[dice1-1].getCount() == 0 || Game.pointList[dice1-1].getColor() == "Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry(24, dice1-1));
                }
                if (Game.pointList[dice2-1].getCount() == 0 || Game.pointList[dice2-1].getColor() == "Red") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry(24, dice2-1));
                    }
                }
                if (Game.pointList[dice1-1].getCount() == 1 && Game.pointList[dice1-1].getColor() == "Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "* ");
                    movesList.add(new AbstractMap.SimpleEntry(24, dice1-1));
                }
                if (Game.pointList[dice2-1].getCount() == 1 && Game.pointList[dice2-1].getColor() == "Black") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "* ");
                        movesList.add(new AbstractMap.SimpleEntry(24, dice2-1));
                    }
                }
            }
            for (int i = 0; i < 24; i++) {
                if (Game.pointList[i].getColor() == "Red" && Game.pointList[i].getCount() != 0) {
                    if (Game.pointList[i + dice1].getCount() == 0 || Game.pointList[i + dice1].getColor() == "Red") {
                        if (i + dice1 < 24) {
                            window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice1) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry(i, i+dice1));
                        }
                    }
                    if (Game.pointList[i + dice2].getCount() == 0 || Game.pointList[i + dice2].getColor() == "Red") {
                        if (i + dice2 < 24 && dice1!=dice2) {
                            window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice2) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry(i, i+dice2));
                        }
                    }
                    if (Game.pointList[i + dice1].getColor() == "Black" && Game.pointList[i + dice1].getCount() == 1) {
                        window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice1) + "* ");
                        movesList.add(new AbstractMap.SimpleEntry(i, i+dice1));
                    }
                    if (Game.pointList[i + dice2].getColor() == "Black" && Game.pointList[i + dice2].getCount() == 1) {
                        if(dice1!=dice2) {
                            window.infoLabel.append(Integer.toString(i) + "=" + Integer.toString(i + dice2) + "* ");
                            movesList.add(new AbstractMap.SimpleEntry(i, i+dice2));
                        }
                    }
                    //Bear-off moves
                    if (checkBearOffPossible()) {
                        if ((i + dice1) > 23) {
                            window.infoLabel.append(i + "-OFF ");
                            movesList.add(new AbstractMap.SimpleEntry(i, 27));
                        }
                        if ((i + dice2) > 23 && dice1!=dice2) {
                            window.infoLabel.append(i + "-OFF ");
                            movesList.add(new AbstractMap.SimpleEntry(i, 27));
                        }
                    }
                }
            }
        } else {
            dice1 = window.dice2.getDice1();
            dice2 = window.dice2.getDice2();
            //Bar moves
            if (Game.pointList[25].getCount() != 0) {
                if (Game.pointList[24 - dice1].getCount() == 0 || Game.pointList[24 - dice1].getColor() == "Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry(25, 24-dice1));
                }
                if (Game.pointList[24 - dice2].getCount() == 0 || Game.pointList[24 - dice2].getColor() == "Black") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry(25, 24-dice2));
                    }
                }
                if (Game.pointList[24 - dice1].getCount() == 1 && Game.pointList[24 - dice1].getColor() == "Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "* ");
                    movesList.add(new AbstractMap.SimpleEntry(25, 24-dice1));
                }
                if (Game.pointList[24 - dice2].getCount() == 1 && Game.pointList[24 - dice2].getColor() == "Red") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "* ");
                        movesList.add(new AbstractMap.SimpleEntry(25, 24-dice2));
                    }
                }
            }
            for (int i = 23; i >= 0; i--) {
                if (Game.pointList[i].getColor() == "Black" && Game.pointList[i].getCount() != 0) {
                    if (Game.pointList[i - dice1].getCount() == 0 || Game.pointList[i - dice1].getColor() == "Black") {
                        if (i - dice1 >= 0) {
                            window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString(23 -  i + dice1) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry(23-i, i + dice1));
                        }
                    }
                    if (Game.pointList[i - dice2].getCount() == 0 || Game.pointList[i - dice2].getColor() == "Black") {
                        if (i - dice2 >= 0 && dice1!=dice2) {
                            window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString(23 - i + dice2) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry(23-i, i + dice2));
                        }
                    }
                    if (Game.pointList[i - dice1].getColor() == "Red" && Game.pointList[i - dice1].getCount() == 1) {
                        window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString(23 - i + dice1) + "* ");
                        movesList.add(new AbstractMap.SimpleEntry(23-i, i + dice1));
                    }
                    if (Game.pointList[i - dice2].getColor() == "Red" && Game.pointList[i - dice2].getCount() == 1 && dice1!=dice2) {
                        window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString( 23 - i + dice2) + "* ");
                        movesList.add(new AbstractMap.SimpleEntry(23-i, i + dice2));
                    }
                    //Bear-off moves
                    if (checkBearOffPossible()) {
                        if ((i - dice1) < 0) {
                            window.infoLabel.append(23-i + "-OFF ");
                            movesList.add(new AbstractMap.SimpleEntry(23-i, 26));
                        }
                        if ((i + dice2) < 0 && dice1 != dice2) {
                            window.infoLabel.append(23-i + "-OFF ");
                            movesList.add(new AbstractMap.SimpleEntry(23-i, 26));
                        }
                    }
                }
            }
        }
    }
    private static Boolean checkBearOffPossible() {
        if(Game.currentPlayer) {
            for (int i = 0; i < 18; i++) {
                if (Game.pointList[i].getColor() == "Red") {
                    return false;
                }
            }
            if (Game.pointList[24].getColor() == "Red") {
                return false;
            }
        } else {
            for (int i = 23; i > 5; i--) {
                if (Game.pointList[i].getColor() == "Black") {
                    return false;
                }
            }
            if (Game.pointList[25].getColor() == "Black") {
                return false;
            }
        }
        return true;
    }
}