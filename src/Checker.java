import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Checker {
    public Checker(int startX, int startY, String color) {
        //Designs checkers and adds to board
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window = new Ellipse2D.Double(startX, startY, 32, 32);
        if(color=="Black") {
            g.setColor(Color.BLACK);
        }
        if(color=="White") {
            g.setColor(Color.RED);
        }
        g.fill(Window);
    }
}
