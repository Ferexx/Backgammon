import static java.lang.Thread.sleep;

public class Controller {
    public static void main(String args[]) throws Exception {
        try {new Display();
        new Dice();
        //Adding to avoid race condition where checkers are drawn before board is, resulting in board being drawn over them
        sleep(25);
        Checker.startingPositions();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
