public class Controller {

    //PlayerPlaying string will be used for controlling turns and which dice display
    //Currently only used for displaying Dice
    protected static String PlayerPlaying = "Player1";

    public static void main(String args[]) {
        try {
            new Display();
            //Adding to avoid race condition where checkers are drawn before board is, resulting in board being drawn over them
            //sleep(50); //not necessary anymore as initPoints takes up enough time
            initPoints();
            startingPositions();
            storeCheckers[0].move(pointList[1], "Red");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    private static Point[] pointList = new Point[24];
    private static int[] pointXCoords = new int[]{665,615,566,516,466,415,324,274,224,174,125,75,75,125,174,224,274,324,416,466,516,566,615,665};
    private static int[] pointYCoords = new int[]{540,540,540,540,540,540,540,540,540,540,540,540,51,51,51,51,51,51,51,51,51,51,51,51};
    private static Checker[] storeCheckers = new Checker[30];

    private static void initPoints() {
        for(int i=0; i<24; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
    }
    private static void startingPositions() {
        for(int i=0; i<30; i++) {
            if(i<2) {
                storeCheckers[i] = new Checker(pointList[0], "Red");
                pointList[0].addChecker();
            }
            if(i>1&&i<7) {
                storeCheckers[i] = new Checker(pointList[5], "Black");
                pointList[5].addChecker();
            }
            if(i>6&&i<10) {
                storeCheckers[i] = new Checker(pointList[7], "Black");
                pointList[7].addChecker();
            }
            if(i>9&&i<15) {
                storeCheckers[i] = new Checker(pointList[11], "Red");
                pointList[11].addChecker();
            }
            if(i>14&&i<20) {
                storeCheckers[i] = new Checker(pointList[12], "Black");
                pointList[12].addChecker();
            }
            if(i>19&&i<23) {
                storeCheckers[i] = new Checker(pointList[16], "Red");
                pointList[16].addChecker();
            }
            if(i>22&&i<28) {
                storeCheckers[i] = new Checker(pointList[18], "Red");
                pointList[18].addChecker();
            }
            if(i>27&&i<30) {
                storeCheckers[i] = new Checker(pointList[23], "Black");
                pointList[23].addChecker();
            }
        }
    }
    public static void redrawPoint(Point point) {
        for(int i=0;i<30;i++) {
            if (point == storeCheckers[i].getCurrentPoint()) {
                storeCheckers[i].drawChecker(point, storeCheckers[i].getCurrentColor());
            }
        }
    }
}
