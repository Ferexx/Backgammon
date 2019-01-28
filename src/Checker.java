import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Checker {
    private Point currentPoint;
    public Checker(Point point, String color) {
        this.currentPoint = point;
        //Designs checkers and adds to board
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window;
        if(point.getyLoc()==51) {
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
    public Point getCurrentPoint() {
        return this.currentPoint;
    }
    public void setCurrentPoint(Point point) {
        this.currentPoint = point;
    }
}
