import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawing extends JPanel {

    //Image declaration for Drawing
    private BufferedImage boardImg;
    private final Window window;

    public Drawing(Window window){
        //SoundManager.playSound();
        this.window = window;
        try {
            boardImg = ImageIO.read(this.getClass().getResource("res/Images/SmallBoard.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    //Basic move function, removes a checker from chosen point, and adds to new point, as well as updating color.
    public void move(Point from, Point to) {
        from.removeChecker();
        if(to.getCount()==1) {
            if(Game.currentPlayer) {
                if(to.getColor()=="Black") {
                    Game.pointList[25].addChecker();
                    to.setColor(from.getColor());
                    update();
                    return;
                }
            }
            else {
                if(to.getColor()=="Red") {
                    Game.pointList[24].addChecker();
                    to.setColor(from.getColor());
                    update();
                    return;
                }
            }
        }
        to.setColor(from.getColor());
        if(from.getCount()==0) {
            from.setColor(null);
        }
        to.addChecker();
        update();
        commandHandler.checkWin(window);
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
        Graphics2D g = (Graphics2D) graphics;
        //Draw the board
        g.drawImage(boardImg,265,20,743, 600, null);
        DoublingCube.drawCube(g);
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
            } else {
                if (Game.pointList[i].getyLoc() == 60) {
                    g.drawString(Integer.toString(23-i), Game.pointList[i].getxLoc() + 5, Game.pointList[i].getyLoc() - 10);
                } else {
                    g.drawString(Integer.toString(23-i), Game.pointList[i].getxLoc() + 5, Game.pointList[i].getyLoc() + 52);
                }
            }
            Game.pointList[i].drawPoint(g);
        }

        //Drawing dice
        window.p1D1.draw(g);
        window.p1D2.draw(g);
        window.p2D1.draw(g);
        window.p2D2.draw(g);

        //Drawing score
        g.setColor(Color.RED);
        g.drawString("P1 Score: "+commandHandler.player1.getScore(), 800, 15);
        g.setColor(Color.BLACK);
        g.drawString("P2 Score: "+commandHandler.player2.getScore(), 900, 15);
        g.setColor(Color.GREEN);
        g.drawString("Winning Score: "+commandHandler.finalScore, 650, 15);

        //Drawing bar
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(24), Game.pointList[24].getxLoc()+5, Game.pointList[24].getyLoc()-5);
        g.drawString(Integer.toString(25), Game.pointList[25].getxLoc()+5, Game.pointList[25].getyLoc()+47);
        Game.pointList[24].drawPoint(g);
        Game.pointList[25].drawPoint(g);
        g.setColor(Color.BLACK);
        g.drawString("B", 630, 300);
        g.drawString("A", 630, 315);
        g.drawString("R", 630, 330);

        //Drawing bear off
        g.drawString(Integer.toString(26), Game.pointList[26].getxLoc()+5, Game.pointList[26].getyLoc()-5);
        g.drawString(Integer.toString(27), Game.pointList[27].getxLoc()+5, Game.pointList[27].getyLoc()+52);
        Game.pointList[26].drawSides(g);
        Game.pointList[27].drawSides(g);
        g.setColor(Color.BLACK);
        g.drawString("Bear-Off", 195, 320);
    }
}
