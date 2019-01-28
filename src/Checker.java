import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Checker {

    private static Checker[] storeCheckers = new Checker[30];
    private static int[] pointXCoords = new int[]{75, 125, 175, 225, 275, 325, 416, 466, 516, 566, 615, 665, 665, 615, 566, 516, 466, 416, 325, 275, 225, 175, 125, 75};
    private static int[] pointYCoords = new int[]{58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 535, 535, 535, 535, 535, 535, 535, 535, 535, 535, 535, 535};


    public Checker(int startX, int startY) {
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window = new Ellipse2D.Double(startX, startY, 32, 32);
        g.setColor(Color.BLACK);
        g.fill(Window);
    }

    public static void startingPositions() {
        for(int i =0; i<24; i++) {
            storeCheckers[i] = new Checker(pointXCoords[i], pointYCoords[i]);
        }
    }


}
