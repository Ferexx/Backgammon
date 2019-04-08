import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class DoublingCube {
    public static int doublingCube=1;
    public static int playerDoubling=0; //Used to keep track of which player has the cube
    public static void drawCube(Graphics2D g) {
        g.setColor(Color.BLACK);
        //Attributed string so we can increase the size of text without affecting overall drawString size
        AttributedString cube =  new AttributedString(Integer.toString(doublingCube));
        if(doublingCube==1) cube = new AttributedString(Integer.toString(64));
        cube.addAttribute(TextAttribute.SIZE, 40);
        //Increasing thickness of line for cube border
        g.setStroke(new BasicStroke(5));
        if(playerDoubling==0) {
            g.drawRect(90, 275, 80, 80);
            //Changing where the string is drawn based on if we have to draw two digits or one
            if (doublingCube > 8 || doublingCube==1) g.drawString(cube.getIterator(), 106, 327);
            else g.drawString(cube.getIterator(), 118, 328);
        } else if(playerDoubling==1) {
            g.drawRect(180, 30, 80, 80);
            if (doublingCube > 8 || doublingCube==1) g.drawString(cube.getIterator(), 196, 82);
            else g.drawString(cube.getIterator(), 208, 86);
        } else if(playerDoubling==2) {
            g.drawRect(180, 530, 80, 80);
            if (doublingCube > 8 || doublingCube==1) g.drawString(cube.getIterator(), 196, 582);
            else g.drawString(cube.getIterator(), 208, 586);
        }
    }
    public static void doubleCube() {
        doublingCube*=2;
    }
}
