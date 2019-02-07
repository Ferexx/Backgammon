import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board {

    //Image icon declaration for board
    private static ImageIcon image;

    //MAKING BOARD A REALITY
    public Board(Window window){
        //Assigning an image to a new Board object
        image = new ImageIcon(window.getClass().getResource("Resources/SmallBoard.png"));
        //Giving the board a padding border
        Window.boardLabel = new JLabel(image);
        Window.boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 48 ) );
    }
    public void move(Point from, Point to) {
        from.removeChecker();
        to.addChecker();
        update();
    }
    public void update() {
        Window.boardLabel.repaint();
        for(int i=0;i<26;i++) {
            Controller.pointList[i].drawPoint();
        }
    }
}