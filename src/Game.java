//Main Class
class Game {

    //We use the boolean "player" to handle player turns. Player 1 = true, player 2 = false.
    public static boolean currentPlayer = true;

    //PlayerPlaying string will be used for controlling turns and which dice display
    //Currently only used for displaying Dice
    protected static String PlayerPlaying = "Player1";
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;
    private final String TITLE = "Backgammon Window - Pre-Alpha v1.0";

    private final commandHandler commands = new commandHandler();
    private final Window window = new Window(WIDTH,HEIGHT,TITLE,commands);

    //Main function, used to get game started, as well as testing new functionality
    public static void main(String[] args) {
            initPoints();
            Game game = new Game();
            game.commands.setNames(game.window);
    }

    public static final Point[] pointList = new Point[28];
    //Last two points are bear off points, previous two are bar points
    private static final int[] pointXCoords = new int[]{915,865,816,766,716,665,574,524,474,424,375,325,325,375,424,474,524,574,665,716,766,816,865,915,620,620,230,230};
    private static final int[] pointYCoords = new int[]{547,547,547,547,547,547,547,547,547,547,547,547,60,60,60,60,60,60,60,60,60,60,60,60,357,233,357,233};

    //Create points and assign them their pixel locations
    private static void initPoints() {
        for(int i=0; i<28; i++) {
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
        pointList[24].setColor("Red");
        pointList[25].setColor("Black");
        pointList[26].setColor("Red");
        pointList[27].setColor("Black");
    }
}
