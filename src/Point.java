import java.awt.*;

public class Point {

    private int count;
    private final int xLoc;
    private final int yLoc;
    private String occupyingColor;
    private static final int CHECKER_DIAMETER = 32, CHECKER_WIDTH = 32, CHECKER_HEIGHT = 5;

    public Point(int x, int y)  {
        this.xLoc = x;
        this.yLoc = y;
    }

    public void addChecker() {
        count++;
    }
    public void removeChecker() {
        count--;
    }
    public void clearCheckers() {
        count = 0;
    }
    public void setCheckers(int count) {
        this.count=count;
    }
    public int getCount() {
        return count;
    }
    public int getxLoc() {
        return this.xLoc;
    }
    public int getyLoc() {
        return this.yLoc;
    }
    public void setColor(String color) {
        this.occupyingColor=color;
    }
    public String getColor() {
        return this.occupyingColor;
    }

    public void drawPoint(Graphics2D g) {
        if(occupyingColor=="Black") {
            g.setColor(Color.BLACK);
        }
        if(occupyingColor=="Red") {
            g.setColor(Color.RED);
        }
        for(int i=0;i<count;i++) {
            if (yLoc == 60 || yLoc == 357) {
                g.fillOval(xLoc, yLoc + i*CHECKER_DIAMETER, CHECKER_DIAMETER, CHECKER_DIAMETER);
            } else {
                g.fillOval(xLoc, yLoc - i*CHECKER_DIAMETER, CHECKER_DIAMETER, CHECKER_DIAMETER);
            }
        }
    }
    public void drawSides(Graphics2D g) {
        if(occupyingColor=="Black") {
            g.setColor(Color.BLACK);
        }
        if(occupyingColor=="Red") {
            g.setColor(Color.RED);
        }
        for(int i=0;i<count;i++) {
            if (yLoc == 357) {
                g.fillRect(xLoc, yLoc + i*10, CHECKER_WIDTH, CHECKER_HEIGHT);
            } else {
                g.fillRect(xLoc, yLoc - i*10, CHECKER_WIDTH, CHECKER_HEIGHT);
            }
        }
    }
}
