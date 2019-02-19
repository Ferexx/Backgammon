import static java.lang.Thread.sleep;

//Main Class
public class Game {

    public String player1;
    public String player2;

    //PlayerPlaying string will be used for controlling turns and which dice display
    //Currently only used for displaying Dice
    protected static String PlayerPlaying = "Player1";
    private int WIDTH = 1280, HEIGHT = 720;
    private final String TITLE = "Backgammon Window - Pre-Alpha v1.0";

    private final commandHandler commands = new commandHandler();
    private final Window window = new Window(WIDTH,HEIGHT,TITLE,commands);

    //Main function, used to get game started, as well as testing new functionality
    public static void main(String[] args) {
        try {
            initPoints();
            Game game = new Game();
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
    private static int[] pointXCoords = new int[]{915,865,816,766,716,665,574,524,474,424,375,325,325,375,424,474,524,574,665,716,766,816,865,915,620,620};
    private static int[] pointYCoords = new int[]{547,547,547,547,547,547,547,547,547,547,547,547,60,60,60,60,60,60,60,60,60,60,60,60,357,233};

    //Create points and assign them their pixel locations
    private static void initPoints() {
        for(int i=0; i<26; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
        pointList[0].setCheckers(2);
        pointList[0].setColor("Red");
        pointList[5].setCheckers(5);
        pointList[5].setColor("Black");
        pointList[7].setCheckers(3);
        pointList[7].setColor("Black");
        pointList[11].setCheckers(5);
        pointList[11].setColor("Red");
        pointList[12].setCheckers(5);
        pointList[12].setColor("Black");
        pointList[16].setCheckers(3);
        pointList[16].setColor("Red");
        pointList[18].setCheckers(5);
        pointList[18].setColor("Red");
        pointList[23].setCheckers(2);
        pointList[23].setColor("Black");
    }


    public void demoCheckers(Window window) {
        try {
            window.board.move(pointList[0], pointList[1]);
            sleep(3000);
            window.board.move(pointList[1], pointList[10]);
            sleep(3000);
            window.board.move(pointList[10], pointList[16]);
            sleep(3000);
            window.board.move(pointList[16], pointList[23]);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
