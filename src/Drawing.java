import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawing extends JPanel {

    //Image icon declaration for Drawing
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
        //Draw the board
        g.drawImage(boardImg,265,20,743, 600, null);
        //Drawing numbers on points
        g.setFont(new Font("Courier",Font.BOLD,16));
        //Loop with check to change which way the numbers are drawn based on whose turn it is
        for(int i=0;i<24;i++) {
            g.setColor(Color.BLACK);
            if(Game.currentPlayer) {
                if (Game.pointList[i].getyLoc() == 60) {
                    g.drawString(Integer.toString(i), Game.pointList[i].getxLoc() + 5, Game.pointList[i].getyLoc() - 10);
                } else {
                    g.drawString(Integer.toString(i), Game.pointList[i].getxLoc() + 5, Game.pointList[i].getyLoc() + 52);
                }
            }
            else {
                if (Game.pointList[i].getyLoc() == 60) {
                    g.drawString(Integer.toString(23-i), Game.pointList[i].getxLoc() + 5, Game.pointList[i].getyLoc() - 10);
                } else {
                    g.drawString(Integer.toString(23-i), Game.pointList[i].getxLoc() + 5, Game.pointList[i].getyLoc() + 52);
                }
            }
            Game.pointList[i].drawPoint(g);
        }

        //Drawing dice
        window.dice1.drawDice(g, true);
        window.dice2.drawDice(g, false);

        //Drawing bar
        g.drawString(Integer.toString(24), Game.pointList[24].getxLoc()+5, Game.pointList[24].getyLoc()-5);
        g.drawString(Integer.toString(25), Game.pointList[25].getxLoc()+5, Game.pointList[25].getyLoc()+47);
        Game.pointList[24].drawPoint(g);
        Game.pointList[25].drawPoint(g);
        g.drawString("B", 630, 300);
        g.drawString("A", 630, 315);
        g.drawString("R", 630, 330);

        //Drawing bear off
        Game.pointList[26].drawSides(g);
        Game.pointList[27].drawSides(g);
        g.drawString("Bear-Off", 195, 320);
    }
}