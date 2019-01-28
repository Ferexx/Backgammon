import static java.lang.Thread.sleep;

public class Controller {
    public static void main(String args[]) throws Exception {
        try {new Display();
        new Dice();
        sleep(100);
        Checker.startingPositions();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
