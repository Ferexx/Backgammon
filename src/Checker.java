import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import static java.lang.Thread.sleep;

public class Checker extends JComponent {
    private Point currentPoint;
    private String color;
    public Checker(Point point, String color) {
        setCurrentPoint(point);
        setCurrentColor(color);
        drawChecker(point, color);
    }
    //Getters and setters
    public Point getCurrentPoint() {
        return this.currentPoint;
    }
    public void setCurrentPoint(Point point) {
        this.currentPoint = point;
    }
    public String getCurrentColor() {
        return color;
    }
    public void setCurrentColor(String color) {
        this.color = color;
    }

    /*Basic drawing method, calls paintComponent to draw checkers,
    * then adds one to the number of checkers on the current point.*/
    public void drawChecker(Point point, String color) {
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        setCurrentPoint(point);
        paintComponent(g);
        currentPoint.addChecker();
    }

    /* Clears the topmost checker on the current point, then repaints the board.
    * Repainting the board is necessary because clearRect also erases any underlying
    * images, meaning we get white squares in our image.
    * After that it updates the currentPoint of the checker.*/
    public void move(Point point) {
        try {
            Graphics graphics = Window.boardLabel.getGraphics();
            Graphics2D g = (Graphics2D) graphics;
            if(getCurrentPoint().getyLoc()==51||getCurrentPoint().getyLoc()==327) {
                g.clearRect(currentPoint.getxLoc(), currentPoint.getyLoc() + currentPoint.getDrawingOffset() - 32, 32, 32);
            }
            else {
                g.clearRect(currentPoint.getxLoc(), currentPoint.getyLoc() - currentPoint.getDrawingOffset() + 32, 32, 32);
            }
            Window.boardLabel.repaint();
            sleep(100);
            currentPoint.clearCheckers();
            setCurrentPoint(point);
            currentPoint.addChecker();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /* Overrides default paintComponent method for our own nefarious uses.
    * First determines color to use when drawing.
    * Second draws a circle at the currentPoint. The drawing offset is called
    * so that checkers are separated and stack nicely on top of each other in
    * the window.*/
    public void paintComponent(Graphics g) {
        if(getCurrentColor()=="Black") {
            g.setColor(Color.BLACK);
        }
        if(getCurrentColor()=="Red") {
            g.setColor(Color.RED);
        }
        if(getCurrentPoint().getyLoc()==51||getCurrentPoint().getyLoc()==327) {
            g.fillOval(currentPoint.getxLoc(), currentPoint.getyLoc() + currentPoint.getDrawingOffset(), 32, 32);
        }
        else {
            g.fillOval(currentPoint.getxLoc(), currentPoint.getyLoc() - currentPoint.getDrawingOffset(), 32, 32);
        }

    }
}
