import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Checker extends JComponent {
    private Point currentPoint;
    private Ellipse2D Circle;
    public Checker(Point point, String color) {
        this.currentPoint = point;
        //Designs checkers and adds to board
        drawChecker(point, color);
    }
    public Point getCurrentPoint() {
        return this.currentPoint;
    }
    public void setCurrentPoint(Point point) {
        this.currentPoint = point;
    }
    public void drawChecker(Point point, String color) {
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        if(point.getyLoc()==51) {
            Circle = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() + point.getDrawingOffset(), 32, 32);
        }
        else {
            Circle = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() - point.getDrawingOffset(), 32, 32);
        }
        if(color=="Black") {
            g.setColor(Color.BLACK);
        }
        if(color=="Red") {
            g.setColor(Color.RED);
        }
        g.fill(Circle);
    }
    public void redraw(Point point, String color) {
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        g.clearRect(this.currentPoint.getxLoc(), this.currentPoint.getyLoc(),32,32);
        if(point.getyLoc()==51) {
            Circle = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() + point.getDrawingOffset(), 32, 32);
        }
        else {
            Circle = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() - point.getDrawingOffset(), 32, 32);
        }
        if(color=="Black") {
            g.setColor(Color.BLACK);
        }
        if(color=="Red") {
            g.setColor(Color.RED);
        }
        g.fill(Circle);
        setCurrentPoint(point);
    }
}
