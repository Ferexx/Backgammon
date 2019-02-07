import java.awt.*;

public class Point {
    private int count, xLoc, yLoc;
    private String occupyingColor;
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

    public void drawPoint() {
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        if(occupyingColor=="Black") {
            g.setColor(Color.BLACK);
        }
        if(occupyingColor=="Red") {
            g.setColor(Color.RED);
        }
        for(int i=0;i<count;i++) {
            if (yLoc == 51 || yLoc == 327) {
                g.fillOval(xLoc, yLoc + i*32, 32, 32);
            } else {
                g.fillOval(xLoc, yLoc - i*32, 32, 32);
            }
        }
    }
}
