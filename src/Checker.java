import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Checker {

    public Checker(int startX, int startY) {
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window = new Ellipse2D.Double(startX, startY, 32, 32);
        g.setColor(Color.BLACK);
        g.fill(Window);
    }


}
