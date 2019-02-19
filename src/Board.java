import javax.imageio.ImageIO;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Board extends JPanel {

    //Image icon declaration for board
    private BufferedImage boardImg;
    private Graphics2D g;

    public Board(){
        //SoundManager.playSound();
        try {
            boardImg = ImageIO.read(this.getClass().getResource("Resources/SmallBoard.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void move(Point from, Point to) {
        from.removeChecker();
        to.addChecker();
        to.setColor(from.getColor());
        update();
    }

    public void update() {
        revalidate();
        repaint();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        g = (Graphics2D) graphics;
        //Draw board
        g.drawImage(boardImg,265,20,743, 600, null);
        //Drawing numbers on points
        g.setFont(new Font("Courier",Font.BOLD,16));
        for(int i=0;i<24;i++) {
            g.setColor(Color.BLACK);
            if(Game.pointList[i].getyLoc()==60) {
                g.drawString(Integer.toString(i), Game.pointList[i].getxLoc()+5, Game.pointList[i].getyLoc()-10);
            }
            else {
                g.drawString(Integer.toString(i),Game.pointList[i].getxLoc()+5,Game.pointList[i].getyLoc()+52);
            }
            Game.pointList[i].drawPoint(g);
        }
    }
}