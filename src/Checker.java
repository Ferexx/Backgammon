import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import static java.lang.Thread.sleep;

public class Checker extends JComponent {
    private Point currentPoint;
    private Ellipse2D Circle;
    private String color;
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
    public String getCurrentColor() {
        return color;
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
            this.color = "Black";
        }
        if(color=="Red") {
            g.setColor(Color.RED);
            this.color = "Red";
        }
        g.fill(Circle);
    }
    public void move(Point point, String color) {
        try {
            Graphics graphics = Window.boardLabel.getGraphics();
            Graphics2D g = (Graphics2D) graphics;
            g.clearRect(this.currentPoint.getxLoc(), this.currentPoint.getyLoc(), 32, 32);
            if (point.getyLoc() == 51) {
                Circle = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() + point.getDrawingOffset(), 32, 32);
            } else {
                Circle = new Ellipse2D.Double(point.getxLoc(), point.getyLoc() - point.getDrawingOffset(), 32, 32);
            }
            if (color == "Black") {
                g.setColor(Color.BLACK);
            }
            if (color == "Red") {
                g.setColor(Color.RED);
            }
            g.fill(Circle);
            this.currentPoint.clearCheckers();
            Point temp = this.currentPoint;
            setCurrentPoint(point);
            Controller.redrawPoint(temp);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
