import static java.lang.Thread.sleep;

//Main Class
public class Controller {

    //PlayerPlaying string will be used for controlling turns and which dice display
    //Currently only used for displaying Dice
    protected static String PlayerPlaying = "Player1";

    //Main function, used to get game started, as well as testing new functionality
    public static void main(String[] args) {
        try {
            Display display = new Display();
            initPoints();
            startingPositions();
            //democheckers demonstrates out movement capabilities of the checkers
            sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public static Point[] pointList = new Point[26];
    //Last two points are bar points
    private static int[] pointXCoords = new int[]{665,615,566,516,466,415,324,274,224,174,125,75,75,125,174,224,274,324,416,466,516,566,615,665,370,370};
    private static int[] pointYCoords = new int[]{540,540,540,540,540,540,540,540,540,540,540,540,51,51,51,51,51,51,51,51,51,51,51,51,327,263};

    //Create points and assign the them their pixel locations
    private static void initPoints() {
        for(int i=0; i<26; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
    }
    //Set up checkers in their initial positions
    private static void startingPositions() {
        for(int i=0; i<30; i++) {
            if(i==0) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");
                pointList[i].drawPoint();
            }
            if(i==5) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");
                pointList[i].drawPoint();

            }
            if(i==7) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");
                pointList[i].drawPoint();
            }
            if(i==11) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");
                pointList[i].drawPoint();
            }
            if(i==12) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");
                pointList[i].drawPoint();
            }
            if(i==16) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");
                pointList[i].drawPoint();

            }
            if(i==18) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");
                pointList[i].drawPoint();
            }
            if(i==23) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");
                pointList[i].drawPoint();
            }
        }
    }
}
