import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board {

    private JLabel boardLabel;
    private ImageIcon image;

    public void Board(){

        Board board = new Board();//sets the board onto the screen from the graphics folder
        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        //Giving the board a padding border
        boardLabel = new JLabel(image);
        boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 64 ) );
    }
    //All Board stuff from Window.java will be in here asap

}
