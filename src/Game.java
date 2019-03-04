//Main Class
class Game {

    //We use the boolean "player" to handle player turns. Player 1 = true, player 2 = false.
    public static boolean currentPlayer;

    //PlayerPlaying string will be used for controlling turns and which dice display
    //Currently only used for displaying Dice
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

            //Adding Drawing image to JFrame after name input
            game.window.frame.getContentPane().add(game.window.drawing);
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

    //Checker positions for the cheat command testing
    protected static void cheatPoints() {
        for(int i=0; i<28; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
        pointList[0].setCheckers(3);
        pointList[0].setColor("Black");
        pointList[2].setCheckers(3);
        pointList[2].setColor("Black");
        pointList[3].setCheckers(3);
        pointList[3].setColor("Black");
        pointList[19].setCheckers(2);
        pointList[19].setColor("Red");
        pointList[20].setCheckers(2);
        pointList[20].setColor("Red");
        pointList[21].setCheckers(2);
        pointList[21].setColor("Red");
        pointList[22].setCheckers(2);
        pointList[22].setColor("Red");
        pointList[23].setCheckers(2);
        pointList[23].setColor("Red");
        pointList[24].setCheckers(3);
        pointList[24].setColor("Red");
        pointList[25].setCheckers(3);
        pointList[25].setColor("Black");
        pointList[26].setCheckers(2);
        pointList[26].setColor("Red");
        pointList[27].setCheckers(3);
        pointList[27].setColor("Black");
    }
}
