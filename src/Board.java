import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Board extends JPanel {

    //Image icon declaration for board
    private BufferedImage boardImg;
    private Graphics2D g;

    public Board(Window window){
        //SoundManager.playSound();
        try {
            boardImg = ImageIO.read(this.getClass().getResource("Resources/SmallBoard.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void move(Point from, Point to, Window window) {
        from.removeChecker();
        to.addChecker();
        to.setColor(from.getColor());
        update(window);
    }

    public void update(Window window) {
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        g = (Graphics2D) graphics;
        //Draw board
        g.drawImage(boardImg,250,16,743, 600, null);
        //Drawing numbers on points
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier",Font.BOLD,16));
        for(int i=0;i<25;i++) {
            if(Game.pointList[i].getyLoc()==51) {
                g.drawString(Integer.toString(i), Game.pointList[i].getxLoc(), Game.pointList[i].getyLoc() - 32);
            }
            else {
                g.drawString(Integer.toString(i),Game.pointList[i].getxLoc(),Game.pointList[i].getyLoc() + 32);
            }
            Game.pointList[i].drawPoint(g);
        }
    }
}