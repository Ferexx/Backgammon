import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class Moves {
    public static void isValidMove(Window window, int from, int to) {
        if(from==-1||to==-1) {
            window.infoLabel.append("\nThat is not a valid input.");
        }
        else if(from > 25 || to > 27 || from < 0 || to < 0) {
            window.infoLabel.append("\nYour move is out of bounds.");
        }
        else if(Game.currentPlayer) {
            if (PointStorage.pointList[from].getCount() == 0) {
                window.infoLabel.append("\nThere is no checker on the starting point.");
            } else {
                window.drawing.move(PointStorage.pointList[from], PointStorage.pointList[to]);
            }
        } else {
            if(from<24&&to<24) {
                if (PointStorage.pointList[23 - from].getCount() == 0) {
                    window.infoLabel.append("\nThere is no checker on the starting point.");
                } else {
                    window.drawing.move(PointStorage.pointList[23 - from], PointStorage.pointList[23 - to]);
                }
            }
            if(from<24&&to==27) {
                if (PointStorage.pointList[23 - from].getCount() == 0) {
                    window.infoLabel.append("\nThere is no checker on the starting point.");
                } else {
                    window.drawing.move(PointStorage.pointList[23 - from], PointStorage.pointList[to]);
                }
            }
            if(from==25&&to<24) {
                if (PointStorage.pointList[from].getCount() == 0) {
                    window.infoLabel.append("\nThere is no checker on the starting point.");
                } else {
                    window.drawing.move(PointStorage.pointList[from], PointStorage.pointList[23-to]);
                }
            }
        }
    }

    public static ArrayList<Map.Entry<Integer, Integer>> movesList = new ArrayList<>();
    public static int getFromMove(char input) {
        int a = input-65;
        if (a>=movesList.size()) {
            return -1;
        }
        Map.Entry<Integer, Integer> move =  movesList.get(a);
        return move.getKey();
    }
    public static int getToMove(char input) {
        int a = input-65;
        if (a>=movesList.size()) {
            return -1;
        }
        Map.Entry<Integer, Integer> move =  movesList.get(a);
        return move.getValue();
    }

    public static void possibleMoves(Window window) {
        movesList.clear();
        window.infoLabel.append("\nYour possible moves are: ");
        int dice1, dice2;
        if(Game.currentPlayer) {
            dice1 = window.p1D1.getRoll();
            dice2 = window.p1D2.getRoll();

            //Bar moves
            if (PointStorage.pointList[24].getCount() != 0) {
                if (PointStorage.pointList[dice1-1].getCount() == 0 || PointStorage.pointList[dice1-1].getColor()=="Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24, dice1-1));
                }
                if (PointStorage.pointList[dice2-1].getCount() == 0 || PointStorage.pointList[dice2-1].getColor()=="Red") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(24, dice2-1));
                    }
                }
                if(PointStorage.pointList[dice1+dice2-1].getCount() == 0 || PointStorage.pointList[dice1+dice2-1].getColor()=="Red") {
                    window.infoLabel.append("BAR-"+Integer.toString(dice1+dice2-1)+ "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24,dice1+dice2-1));
                }
                if (PointStorage.pointList[dice1-1].getCount() == 1 && PointStorage.pointList[dice1-1].getColor()=="Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24, dice1-1));
                }
                if (PointStorage.pointList[dice2-1].getCount() == 1 && PointStorage.pointList[dice2-1].getColor()=="Black") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(24, dice2-1));
                    }
                }
                if(PointStorage.pointList[dice1+dice2-1].getCount() == 1 && PointStorage.pointList[dice1+dice2-1].getColor()=="Black") {
                    window.infoLabel.append("BAR-"+Integer.toString(dice1+dice2-1)+ "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(24,dice1+dice2-1));
                }
            }

            //Main moves
            for (int i = 0; i < 24; i++) {
                if(i+dice1<24 && i+dice2<24 && i+dice1+dice2<24) {
                    if (PointStorage.pointList[i].getColor() == "Red" && PointStorage.pointList[i].getCount() != 0) {
                        if (PointStorage.pointList[i + dice1].getCount() == 0 || PointStorage.pointList[i + dice1].getColor() == "Red") {
                            if (i + dice1 < 24) {
                                window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice1) + "\n");
                                movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1));
                            }
                        }
                        if (PointStorage.pointList[i + dice2].getCount() == 0 || PointStorage.pointList[i + dice2].getColor() == "Red") {
                            if (i + dice2 < 24 && dice1 != dice2) {
                                window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice2) + "\n");
                                movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice2));
                            }
                        }
                        if (PointStorage.pointList[i + dice1 + dice2].getCount() == 0 || PointStorage.pointList[i + dice1 + dice2].getColor() == "Red") {
                            if (i + dice1 + dice2 < 24) {
                                window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice1 + dice2) + "\n");
                                movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1 + dice2));
                            }
                        }
                        if (PointStorage.pointList[i + dice1].getColor() == "Black" && PointStorage.pointList[i + dice1].getCount() == 1) {
                            window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice1) + "*\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1));
                        }
                        if (PointStorage.pointList[i + dice2].getColor() == "Black" && PointStorage.pointList[i + dice2].getCount() == 1) {
                            if (dice1 != dice2) {
                                window.infoLabel.append(Integer.toString(i) + "=" + Integer.toString(i + dice2) + "*\n");
                                movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice2));
                            }
                        }
                        if (PointStorage.pointList[i + dice1 + dice2].getColor() == "Black" && PointStorage.pointList[i + dice1 + dice2].getCount() == 1) {
                            window.infoLabel.append(Integer.toString(i) + "-" + Integer.toString(i + dice1 + dice2) + "*\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i + dice1 + dice2));
                        }
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


        else {
            dice1 = window.p2D1.getRoll();
            dice2 = window.p2D2.getRoll();
            //Bar moves
            if (PointStorage.pointList[25].getCount() != 0) {
                if (PointStorage.pointList[24 - dice1].getCount() == 0 || PointStorage.pointList[24 - dice1].getColor()=="Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice1));
                }
                if (PointStorage.pointList[24 - dice2].getCount() == 0 || PointStorage.pointList[24 - dice2].getColor()=="Black") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice2));
                    }
                }
                if(PointStorage.pointList[24-dice1-dice2].getCount() == 0 || PointStorage.pointList[24-dice1-dice2].getColor()=="Black") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1+dice2-1) + "\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25,24-dice1-dice2));
                }
                if (PointStorage.pointList[24 - dice1].getCount() == 1 && PointStorage.pointList[24 - dice1].getColor()=="Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1-1) + "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice1));
                }
                if (PointStorage.pointList[24 - dice2].getCount() == 1 && PointStorage.pointList[24 - dice2].getColor()=="Red") {
                    if(dice1!=dice2) {
                        window.infoLabel.append("BAR-" + Integer.toString(dice2-1) + "*\n");
                        movesList.add(new AbstractMap.SimpleEntry<>(25, 24-dice2));
                    }
                }
                if(PointStorage.pointList[24-dice1-dice2].getCount() == 1 && PointStorage.pointList[24-dice1-dice2].getColor()=="Red") {
                    window.infoLabel.append("BAR-" + Integer.toString(dice1+dice2-1) + "*\n");
                    movesList.add(new AbstractMap.SimpleEntry<>(25,24-dice1-dice2));
                }
            }


            for (int i = 23; i >= 0; i--) {
                if(i-dice1>=0&&i-dice2>=0&&i-dice1-dice2>=0) {
                    if (PointStorage.pointList[i].getColor() == "Black" && PointStorage.pointList[i].getCount() != 0) {
                        //Standard move
                        if (PointStorage.pointList[i - dice1].getCount() == 0 || PointStorage.pointList[i - dice1].getColor() == "Black") {
                            if (i - dice1 >= 0) {
                                window.infoLabel.append(Integer.toString(23 - i) + "-" + Integer.toString(23 - i + dice1) + "\n");
                                movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1));
                            }
                        }
                        if (PointStorage.pointList[i - dice2].getCount() == 0 || PointStorage.pointList[i - dice2].getColor() == "Black") {
                            if (i - dice2 >= 0 && dice1 != dice2) {
                                window.infoLabel.append(Integer.toString(23 - i) + "-" + Integer.toString(23 - i + dice2) + "\n");
                                movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice2));
                            }
                        }
                        if (PointStorage.pointList[i - dice1 - dice2].getCount() == 0 || PointStorage.pointList[i - dice1 - dice2].getColor() == "Black") {
                            window.infoLabel.append(Integer.toString(23 - i) + "-" + Integer.toString(23 - i + dice1 + dice2) + "\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1 - dice2));
                        }
                        //Move and capture point
                        if (PointStorage.pointList[i - dice1].getColor() == "Red" && PointStorage.pointList[i - dice1].getCount() == 1) {
                            window.infoLabel.append(Integer.toString(23 - i) + "-" + Integer.toString(23 - i + dice1) + "*\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1));
                        }
                        if (PointStorage.pointList[i - dice2].getColor() == "Red" && PointStorage.pointList[i - dice2].getCount() == 1 && dice1 != dice2) {
                            window.infoLabel.append(Integer.toString(23 - i) + "-" + Integer.toString(23 - i + dice2) + "*\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice2));
                        }
                        if (PointStorage.pointList[i - dice1 - dice2].getColor() == "Red" && PointStorage.pointList[i - dice1 - dice2].getCount() == 1) {
                            window.infoLabel.append(Integer.toString(23 - i) + "-" + Integer.toString(23 - i + dice1 + dice2) + "*\n");
                            movesList.add(new AbstractMap.SimpleEntry<>(i, i - dice1 - dice2));
                        }

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
        System.out.println("ArrayMap: "+movesList.toString()+" Size:"+movesList.size());
    }

    private static Boolean checkBearOffPossible() {
        if(Game.currentPlayer) {
            for (int i = 0; i < 18; i++) {
                if (PointStorage.pointList[i].getColor()=="Red") {
                    return false;
                }
            }
            if (PointStorage.pointList[24].getColor()=="Red") {
                return false;
            }
        } else {
            for (int i = 23; i > 5; i--) {
                if (PointStorage.pointList[i].getColor()=="Black") {
                    return false;
                }
            }
            if (PointStorage.pointList[25].getColor()=="Black") {
                return false;
            }
        }
        return true;
    }
}