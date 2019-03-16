import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawing extends JPanel {

    //Image declaration for Drawing
    private BufferedImage boardImg;
    private Graphics2D g;
    private Window window;

    public Drawing(Window window){
        //SoundManager.playSound();
        this.window = window;
        try {
            boardImg = ImageIO.read(this.getClass().getResource("Resources/SmallBoard.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    //Basic move function, removes a checker from chosen point, and adds to new point, as well as updating color.
    public void move(Point from, Point to) {
        from.removeChecker();
        to.setColor(from.getColor());
        if(from.getCount()==0) {
            from.setColor(null);
        }
        to.addChecker();
        update();
    }

    public void update() {
        revalidate();
        repaint();
    }

    /*This large boi deals with all drawing in the game. It starts by drawing the board, then draws the numbers
    around the edges according to whose turn it is. It also draws each point as the loop iterates. It then moves
    on to drawing dice, followed by bar and bear off.
    */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        g = (Graphics2D) graphics;
        //Draw the board
        g.drawImage(boardImg,265,20,743, 600, null);
        //Drawing numbers on points
        g.setFont(new Font("Courier",Font.BOLD,16));
        //Loop with check to change which way the numbers are drawn based on whose turn it is
        for(int i=0;i<24;i++) {
            g.setColor(Color.BLACK);
            if(Game.currentPlayer) {
                if (PointStorage.pointList[i].getyLoc() == 60) {
                    g.drawString(Integer.toString(i), PointStorage.pointList[i].getxLoc() + 5, PointStorage.pointList[i].getyLoc() - 10);
                } else {
                    g.drawString(Integer.toString(i), PointStorage.pointList[i].getxLoc() + 5, PointStorage.pointList[i].getyLoc() + 52);
                }
            } else {
                if (PointStorage.pointList[i].getyLoc() == 60) {
                    g.drawString(Integer.toString(23-i), PointStorage.pointList[i].getxLoc() + 5, PointStorage.pointList[i].getyLoc() - 10);
                } else {
                    g.drawString(Integer.toString(23-i), PointStorage.pointList[i].getxLoc() + 5, PointStorage.pointList[i].getyLoc() + 52);
                }
            }
            PointStorage.pointList[i].drawPoint(g);
        }

        //Drawing dice
        window.p1D1.draw(g);
        window.p1D2.draw(g);
        window.p2D1.draw(g);
        window.p2D2.draw(g);

        //Drawing bar
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(24), PointStorage.pointList[24].getxLoc()+5, PointStorage.pointList[24].getyLoc()-5);
        g.drawString(Integer.toString(25), PointStorage.pointList[25].getxLoc()+5, PointStorage.pointList[25].getyLoc()+47);
        PointStorage.pointList[24].drawPoint(g);
        PointStorage.pointList[25].drawPoint(g);
        g.setColor(Color.BLACK);
        g.drawString("B", 630, 300);
        g.drawString("A", 630, 315);
        g.drawString("R", 630, 330);

        //Drawing bear off
        g.drawString(Integer.toString(26), PointStorage.pointList[26].getxLoc()+5, PointStorage.pointList[26].getyLoc()-5);
        g.drawString(Integer.toString(27), PointStorage.pointList[27].getxLoc()+5, PointStorage.pointList[27].getyLoc()+52);
        PointStorage.pointList[26].drawSides(g);
        PointStorage.pointList[27].drawSides(g);
        g.setColor(Color.BLACK);
        g.drawString("Bear-Off", 195, 320);
    }
}
