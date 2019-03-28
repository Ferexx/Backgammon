import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class DoublingCube {
    public static int doublingCube=1;
    public static int playerDoubling=0;
    public static void drawCube(Graphics2D g) {
        g.setColor(Color.BLACK);
        AttributedString cube =  new AttributedString(Integer.toString(doublingCube));
        cube.addAttribute(TextAttribute.SIZE, 40);
        g.setStroke(new BasicStroke(5));
        if(playerDoubling==0) {
            g.drawRect(90, 275, 80, 80);
            if (doublingCube > 8) g.drawString(cube.getIterator(), 107, 327);
            else g.drawString(cube.getIterator(), 120, 327);
        }
        else if(playerDoubling==1) {
            g.drawRect(180, 30, 80, 80);
            if (doublingCube > 8) g.drawString(cube.getIterator(), 197, 82);
            else g.drawString(cube.getIterator(), 210, 82);
        }
        else if(playerDoubling==2) {
            g.drawRect(180, 530, 80, 80);
            if (doublingCube > 8) g.drawString(cube.getIterator(), 197, 582);
            else g.drawString(cube.getIterator(), 210, 582);
        }
    }
    public static void doubleCube() {
        doublingCube*=2;
    }
}
