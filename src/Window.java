//Java swing imports
import javax.swing.*;

//Java awt layouts
import java.awt.Dimension;

public class Window extends JFrame {

    //Used for the this context
    int x, y, width, height;

    //Declarations for JFrame, JLabel, and ImageIcon
    public ImageIcon image;
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

        //ADDING BOARD
        Board.board(this);

        //ADDING BUTTONS
        Buttons.buttons(this);
    }
}


