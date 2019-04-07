//Main Class

//TODO - add action listener for the TODO in commandHandler
//TODO - fix the games last few moves after the cheat command

class Game {

    //We use the boolean "currentPlayer" to handle player turns. Player 1 = true, Player 2 = false.
    public static boolean currentPlayer;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final String TITLE = "Backgammon Window - Beta v1.5";
    private static final commandHandler commands = new commandHandler();
    private final Window nameWindow = new Window();

    //Main function, used to get game started, as well as testing new functionality
    public static void main(String[] args) {
        initPoints();
        Game game = new Game();
    }

    public static void gameWindow() {
        final Window window = new Window(WIDTH, HEIGHT, TITLE, commands);
        //Adding Drawing image to JFrame after name input
        window.frame.getContentPane().add(window.drawing);
    }

    //Last two points are bear off points, previous two are bar points
    private static final int[] pointXCoords = new int[]{915, 865, 816, 766, 716, 665, 574, 524, 474, 424, 375, 325, 325, 375, 424, 474, 524, 574, 665, 716, 766, 816, 865, 915, 620, 620, 230, 230};
    private static final int[] pointYCoords = new int[]{547, 547, 547, 547, 547, 547, 547, 547, 547, 547, 547, 547, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 357, 233, 357, 233};
    public static final Point[] pointList = new Point[28];

    //Create points and assign them their pixel locations
    static void initPoints() {
        for (int i = 0; i < 28; i++) {
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
    static void cheatPoints() {
        for (int i = 0; i < 28; i++) {
            pointList[i] = new Point(pointXCoords[i], pointYCoords[i]);
        }
        pointList[0].setCheckers(2);
        pointList[0].setColor("Black");
        pointList[23].setCheckers(2);
        pointList[23].setColor("Red");
        pointList[26].setCheckers(13);
        pointList[26].setColor("Black");
        pointList[27].setCheckers(13);
        pointList[27].setColor("Red");
    }
}