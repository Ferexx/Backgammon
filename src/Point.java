public class Point {
    private int count, xLoc, yLoc;
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
    public int getDrawingOffset() {
        return this.count * 32;
    }
    public int getxLoc() {
        return this.xLoc;
    }
    public int getyLoc() {
        return this.yLoc;
    }
}
