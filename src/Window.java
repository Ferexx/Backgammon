//Java swing imports
import javax.swing.border.EmptyBorder;
import javax.swing.*;

//Java awt layouts
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;

public class Window extends JFrame {

    //Hello what doink these are not used blyat someone explique pour moi and why were they not up top
    //Used for the this context
    int x, y, width, height;

    //Declarations for JFrame, JLabel, and ImageIcon
    private ImageIcon image;
    public static JLabel boardLabel;
    static JFrame frame = new JFrame();

    //Declarations for x-axis coordinates for the checker positions
    int[] pointXCoords = new int[]{72, 122, 171, 221, 271, 321, 413, 463, 513, 563, 612, 662};

    //Window constructor - takes in width height and the title on top, all from Display
    Window(int width, int height, String title) {

        //CREATING WINDOW
        //Creating the window frame with title
        frame.setTitle(title);
        //Ensures that window always stays the same dimensions, as set in Display
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        //Ensures that the program quits when you hit (X)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //MAKING BOARD
        board();

        //ADDING BUTTONS
        Buttons.buttons(this);
    }

    //MAKING BOARD A REALITY
    public void board(){
        Board board = new Board();//sets the board onto the screen from the graphics folder
        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        //Giving the board a padding border
        boardLabel = new JLabel(image);
        boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 64 ) );
    }

}


