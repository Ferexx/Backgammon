import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Checker {
    public Checker(Point point, String color) {
        //Designs checkers and adds to board
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window;
        if(point.getyLoc()==58) {
             Window = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() + point.getDrawingOffset(), 32, 32);
        }
        else {
             Window = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() - point.getDrawingOffset(), 32, 32);
        }
        if(color=="Black") {
            g.setColor(Color.BLACK);
        }
        if(color=="Red") {
            g.setColor(Color.RED);
        }
        g.fill(Window);
    }
}
