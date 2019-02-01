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
        setCurrentPoint(point);
        paintComponent(g);
    }
    public void redraw() {
        try{sleep(1000);
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        paintComponent(g);} catch(Exception e) {System.exit(-1);}
    }
    public void move(Point point, String color) {
        try {
            Graphics graphics = Window.boardLabel.getGraphics();
            Graphics2D g = (Graphics2D) graphics;
            if(getCurrentPoint().getyLoc()==51) {
                g.clearRect(this.currentPoint.getxLoc(), this.currentPoint.getyLoc() + currentPoint.getDrawingOffset() - 32, 32, 32);
            }
            else {
                g.clearRect(this.currentPoint.getxLoc(), this.currentPoint.getyLoc() - currentPoint.getDrawingOffset() + 32, 32, 32);
            }
            Window.boardLabel.repaint();
            sleep(100);
            Point temp = this.currentPoint;
            this.currentPoint.clearCheckers();
            setCurrentPoint(point);
            paintComponent(g);
            Controller.redrawPoint(temp);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public void paintComponent(Graphics g) {
        if(getCurrentPoint().getyLoc()==51) {
            g.fillOval(getCurrentPoint().getxLoc(), getCurrentPoint().getyLoc() + getCurrentPoint().getDrawingOffset(), 32, 32);
        }
        else {
            g.fillOval(getCurrentPoint().getxLoc(), getCurrentPoint().getyLoc() - getCurrentPoint().getDrawingOffset(), 32, 32);
        }
        if(color=="Black") {
            g.setColor(Color.BLACK);
            this.color = "Black";
        }
        if(color=="Red") {
            g.setColor(Color.RED);
            this.color = "Red";
        }
        repaint();
    }
}
