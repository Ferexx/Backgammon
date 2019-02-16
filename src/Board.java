import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static java.lang.Thread.sleep;

public class Board {

    //Image icon declaration for board
    private static ImageIcon image;

    public Board(Window window){
        //Assigning an image to a new Board object
        image = new ImageIcon(window.getClass().getResource("Resources/SmallBoard.png"));
        //Giving the board a padding border
        window.boardLabel = new JLabel(image);
        window.boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 48 ) );
        //SoundManager.playSound();
    }
    public void move(Point from, Point to, Window window) {
        from.removeChecker();
        to.addChecker();
        to.setColor(from.getColor());
        update(window);
    }
    public void update(Window window) {
        try{
            window.boardLabel.repaint();
            sleep(100);
            for(int i=0;i<26;i++) {
                Game.pointList[i].drawPoint(window);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }


    }
}