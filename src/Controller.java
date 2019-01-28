import static java.lang.Thread.sleep;

public class Controller {
    public static void main(String args[]) throws Exception {
        try {
            new Display();
            new Dice();
            //Adding to avoid race condition where checkers are drawn before board is, resulting in board being drawn over them
            sleep(50);
            initPoints();
            Checker.startingPositions();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    private static Point[] pointList = new Point[24];
    private static int[] pointXCoords = new int[]{662,612,563,513,463,413,321,271,221,171,122,72,72,122,171,221,271,321,413,463,513,563,612,662};
    private static int[] pointYCoords = new int[]{535,535,535,535,535,535,535,535,535,535,535,535,58,58,58,58,58,58,58,58,58,58,58,58};
    private static Checker[] storeCheckers = new Checker[30];

    private static void initPoints() {
        for(int i=0; i<24; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
    }
    private static void startingPositions() {
        for(int i=0; i<30; i++) {
            if(i<2)
                storeCheckers[i] = new Checker(pointXCoords[0], pointYCoords[0]);
            if(i>1&&i<7)
                storeCheckers[i] = new Checker(pointXCoords[5], pointYCoords[5]);
            if(i>6&&i<10)
                storeCheckers[i] = new Checker(pointXCoords[7], pointYCoords[7]);
            if(i>9&&i<15)
                storeCheckers[i] = new Checker(pointXCoords[11], pointYCoords[11]);
            if(i>14&&i<20)
                storeCheckers[i] = new Checker(pointXCoords[12], pointYCoords[12]);
            if(i>19&&i<23)
                storeCheckers[i] = new Checker(pointXCoords[16], pointYCoords[16]);
            if(i>22&&i<28)
                storeCheckers[i] = new Checker(pointXCoords[18],pointYCoords[18]);
            if(i>27&&i<30)
                storeCheckers[i] = new Checker(pointXCoords[23], pointYCoords[23]);
        }
    }
}
