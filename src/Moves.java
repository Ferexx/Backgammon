public class Moves {
    public static void isValidMove(Window window, int from, int to) {
        if(from > 25 || to > 27 || from < 0 || to < 0) {
            window.infoLabel.append("\nYour move is out of bounds.");
        }
        if(Game.currentPlayer) {
            if (Game.pointList[from].getCount() == 0) {
                window.infoLabel.append("\nThere is no checker on the starting point.");
            }
            else {
                window.drawing.move(Game.pointList[from], Game.pointList[to]);
            }
        }
        else {
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
    public static void possibleMoves(Window window) {
        window.infoLabel.append("\nYour possible moves are: ");
        if(Game.currentPlayer) {
            //Bar moves
            if (Game.pointList[24].getCount() != 0) {
                if (Game.pointList[window.dice1.getDice1()].getCount() == 0 || Game.pointList[window.dice1.getDice1()].getColor() == "Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(24 + window.dice1.getDice1()) + " ");
                }
                if (Game.pointList[window.dice1.getDice2()].getCount() == 0 || Game.pointList[window.dice1.getDice2()].getColor() == "Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(24 + window.dice1.getDice2()) + " ");
                }
                if (Game.pointList[window.dice1.getDice1()].getCount() == 1 && Game.pointList[window.dice1.getDice1()].getColor() == "Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(24 + window.dice1.getDice1()) + "* ");
                }
                if (Game.pointList[window.dice1.getDice2()].getCount() == 1 && Game.pointList[window.dice1.getDice2()].getColor() == "Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(24 + window.dice1.getDice2()) + "* ");
                }
            }
            for (int i = 0; i < 24; i++) {
                if (Game.pointList[i].getColor() == "Red" && Game.pointList[i].getCount() != 0) {
                    if (Game.pointList[i + window.dice1.getDice1()].getCount() == 0 || Game.pointList[i + window.dice1.getDice1()].getColor() == "Red") {
                        if (i + window.dice1.getDice1() < 24) {
                            window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + window.dice1.getDice1()) + " ");
                        }
                    }
                    if (Game.pointList[i + window.dice1.getDice2()].getCount() == 0 || Game.pointList[i + window.dice1.getDice2()].getColor() == "Red") {
                        if (i + window.dice1.getDice2() < 24) {
                            window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + window.dice1.getDice2()) + " ");
                        }
                    }
                    if (Game.pointList[i + window.dice1.getDice1()].getColor() == "Black" && Game.pointList[i + window.dice1.getDice1()].getCount() == 1) {
                        window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + window.dice1.getDice1()) + "* ");
                    }
                    if (Game.pointList[i + window.dice1.getDice2()].getColor() == "Black" && Game.pointList[i + window.dice1.getDice2()].getCount() == 1) {
                        window.infoLabel.append(Integer.toString(i) + "=" + Integer.toString(i + window.dice1.getDice2()) + "* ");
                    }
                    //Bear-off moves
                    if (checkBearOffPossible()) {
                        if ((i + window.dice1.getDice1()) > 23) {
                            window.infoLabel.append(i + "-OFF ");
                        }
                        if ((i + window.dice1.getDice2()) > 23) {
                            window.infoLabel.append(i + "-OFF ");
                        }
                    }
                }
            }
        }
        else {
            //Bar moves
            if (Game.pointList[25].getCount() != 0) {
                if (Game.pointList[24 - window.dice2.getDice1()].getCount() == 0 || Game.pointList[24 - window.dice2.getDice1()].getColor() == "Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(window.dice2.getDice1()) + " ");
                }
                if (Game.pointList[24 - window.dice2.getDice2()].getCount() == 0 || Game.pointList[24 - window.dice2.getDice2()].getColor() == "Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(window.dice2.getDice2()) + " ");
                }
                if (Game.pointList[24 - window.dice2.getDice1()].getCount() == 1 && Game.pointList[24 - window.dice2.getDice1()].getColor() == "Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(window.dice2.getDice1()) + "* ");
                }
                if (Game.pointList[24 - window.dice2.getDice2()].getCount() == 1 && Game.pointList[24 - window.dice2.getDice2()].getColor() == "Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(window.dice2.getDice2()) + "* ");
                }
            }
            for (int i = 23; i >= 0; i--) {
                if (Game.pointList[i].getColor() == "Black" && Game.pointList[i].getCount() != 0) {
                    if (Game.pointList[i - window.dice2.getDice1()].getCount() == 0 || Game.pointList[i - window.dice2.getDice1()].getColor() == "Black") {
                        if (i - window.dice2.getDice1() >= 0) {
                            window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString(23-i + window.dice2.getDice1()) + " ");
                        }
                    }
                    if (Game.pointList[i - window.dice2.getDice2()].getCount() == 0 || Game.pointList[i - window.dice2.getDice2()].getColor() == "Black") {
                        if (i - window.dice2.getDice2() >= 0) {
                            window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString(23 - i + window.dice2.getDice2()) + " ");
                        }
                    }
                    if (Game.pointList[i - window.dice2.getDice1()].getColor() == "Red" && Game.pointList[i - window.dice2.getDice1()].getCount() == 1) {
                        window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString(23 - i + window.dice2.getDice1()) + "* ");
                    }
                    if (Game.pointList[i - window.dice2.getDice2()].getColor() == "Red" && Game.pointList[i - window.dice2.getDice2()].getCount() == 1) {
                        window.infoLabel.append(Integer.toString(23-i) + "-" + Integer.toString( 23 - i + window.dice2.getDice2()) + "* ");
                    }
                    //Bear-off moves
                    if (checkBearOffPossible()) {
                        if ((i - window.dice2.getDice1()) < 0) {
                            window.infoLabel.append(23-i + "-OFF ");
                        }
                        if ((i + window.dice2.getDice2()) < 0) {
                            window.infoLabel.append(23-i + "-OFF ");
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
        }
        else {
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