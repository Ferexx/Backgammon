import static java.lang.Thread.sleep;

public class Controller {

    //PlayerPlaying string will be used for controlling turns and which dice display
    //Currently only used for displaying Dice
    protected static String PlayerPlaying = "Player1";

    //Main function, used to get game started, as well as testing new functionality
    public static void main(String[] args) {
        try {
            new Display();
            initPoints();
            startingPositions();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    private static Point[] pointList = new Point[26];
    //Last two points are bar points
    private static int[] pointXCoords = new int[]{665,615,566,516,466,415,324,274,224,174,125,75,75,125,174,224,274,324,416,466,516,566,615,665,370,370};
    private static int[] pointYCoords = new int[]{540,540,540,540,540,540,540,540,540,540,540,540,51,51,51,51,51,51,51,51,51,51,51,51,327,263};
    private static Checker[] storeCheckers = new Checker[30];

    //Create points and assign the them their pixel locations
    private static void initPoints() {
        for(int i=0; i<26; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
    }
    //Set up checkers in their initial positions
    private static void startingPositions() {
        for(int i=0; i<30; i++) {
            if(i<2) {
                storeCheckers[i] = new Checker(pointList[0], "Red");
            }
            if(i>1&&i<7) {
                storeCheckers[i] = new Checker(pointList[5], "Black");
            }
            if(i>6&&i<10) {
                storeCheckers[i] = new Checker(pointList[7], "Black");
            }
            if(i>9&&i<15) {
                storeCheckers[i] = new Checker(pointList[11], "Red");
            }
            if(i>14&&i<20) {
                storeCheckers[i] = new Checker(pointList[12], "Black");
            }
            if(i>19&&i<23) {
                storeCheckers[i] = new Checker(pointList[16], "Red");
            }
            if(i>22&&i<28) {
                storeCheckers[i] = new Checker(pointList[18], "Red");
            }
            if(i>27&&i<30) {
                storeCheckers[i] = new Checker(pointList[23], "Black");
            }
        }
    }

    /*Used for updating board every time a checker is moved.
     * This is necessary because erasing checkers on the board
      * also erases the underlying board image, so we need to redraw the board.
      * This causes the board to be drawn on top of the existing checker images,
      * meaning that we have to redraw them so that they appear on top.*/
    public static void redrawCheckers() {
        for(int i=0;i<26;i++) {
            pointList[i].clearCheckers();
        }
        for(int i=0;i<30;i++) {
            storeCheckers[i].drawChecker(storeCheckers[i].getCurrentPoint(), storeCheckers[i].getCurrentColor());
        }
    }
    public static void demoCheckers() {
        try {
            storeCheckers[0].move(pointList[25]);
            redrawCheckers();
            sleep(2000);
            storeCheckers[0].move(pointList[2]);
            redrawCheckers();
            sleep(2000);
            storeCheckers[0].move(pointList[7]);
            redrawCheckers();
            sleep(2000);
            storeCheckers[0].move(pointList[13]);
            redrawCheckers();
            sleep(2000);
            storeCheckers[0].move(pointList[20]);
            redrawCheckers();
            sleep(2000);
            storeCheckers[0].move(pointList[23]);
            redrawCheckers();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
