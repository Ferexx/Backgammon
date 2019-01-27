import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board {

    //MAKING BOARD A REALITY
    public static void board(Window window){
        Board board = new Board();//sets the board onto the screen from the graphics folder
        window.image = new ImageIcon(window.getClass().getResource("Graphics/SmallBoard.png"));
        //Giving the board a padding border
        Window.boardLabel = new JLabel(window.image);
        Window.boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 64 ) );
    }

}
