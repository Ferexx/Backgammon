import static java.lang.Thread.sleep;

//Main Class
public class Game {

    public static String player1;
    public static String player2;

    //PlayerPlaying string will be used for controlling turns and which dice display
    //Currently only used for displaying Dice
    protected static String PlayerPlaying = "Player1";
    private static int WIDTH = 1280, HEIGHT = 720;
    private static final String TITLE = "Backgammon Window - Pre-Alpha v1.0";

    private final commandHandler commands = new commandHandler();
    private final Window window = new Window(WIDTH,HEIGHT,TITLE,commands);

    //Main function, used to get game started, as well as testing new functionality
    public static void main(String[] args) {
        try {

            Game game = new Game();
            //Sleeping to avoid race condition
            sleep(1000);

            game.startingPositions(game.window);
            sleep(2000);
            game.demoCheckers(game.window);
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
    private void initPoints() {
        for(int i=0; i<26; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
    }
    //Set up checkers in their initial positions
    private void startingPositions(Window window) {
        //TODO: Get rid of for loop
        for(int i=0; i<30; i++) {
            if(i==0) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");
            }
            if(i==5) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");

            }
            if(i==7) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");
            }
            if(i==11) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");
            }
            if(i==12) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");
            }
            if(i==16) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");

            }
            if(i==18) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Red");
            }
            if(i==23) {
                pointList[i].addChecker();
                pointList[i].addChecker();
                pointList[i].setColor("Black");
            }
        }
    }
    public void demoCheckers(Window window) {
        try {
            window.board.move(pointList[0], pointList[1], window);
            sleep(3000);
            window.board.move(pointList[1], pointList[10], window);
            sleep(3000);
            window.board.move(pointList[10], pointList[16], window);
            sleep(3000);
            window.board.move(pointList[16], pointList[23], window);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
