import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board {

    //Image icon declaration for board
    private static ImageIcon image;

    //MAKING BOARD A REALITY
    public static void board(Window window){
        //Assigning an image to a new Board object
        Board board = new Board();
        image = new ImageIcon(window.getClass().getResource("Resources/SmallBoard.png"));

        //Giving the board a padding border
        Window.boardLabel = new JLabel(image);
        Window.boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 64 ) );
    }
}