import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board {

    //Image icon declaration for board
    private static ImageIcon image;

    //MAKING BOARD A REALITY
    public static void board(Window window){
        Board board = new Board();//sets the board onto the screen from the graphics folder
        image = new ImageIcon(window.getClass().getResource("Resources/SmallBoard.png"));
        //Giving the board a padding border
        Window.boardLabel = new JLabel(image);
        Window.boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 64 ) );
    }

}