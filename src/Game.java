//Main Class
class Game {

    //We use the boolean "currentPlayer" to handle player turns. Player 1 = true, Player 2 = false.
    public static boolean currentPlayer;

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final String TITLE = "Backgammon Window - Pre-Alpha v1.0";
    private static final commandHandler commands = new commandHandler();
    private final Window nameWindow = new Window();
    public static boolean mainFrame = false;

    //Main function, used to get game started, as well as testing new functionality
    public static void main(String[] args) {
            PointStorage.initPoints();
            Game game = new Game();
            while(mainFrame!=true) {try{Thread.sleep(1);}catch(Exception e) {System.exit(-1);}}
            final Window window = new Window(WIDTH,HEIGHT,TITLE,commands);
            //Adding Drawing image to JFrame after name input
            window.mainFrame.getContentPane().add(window.drawing);
    }
}