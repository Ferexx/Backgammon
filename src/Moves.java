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
}