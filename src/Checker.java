import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Checker extends JComponent {
    private Point currentPoint;
    private String color;

    public Checker(Point point, String color) {
        setCurrentPoint(point);
        setCurrentColor(color);
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
}
