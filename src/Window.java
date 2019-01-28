//Java swing imports
import javax.swing.*;

//Java awt layouts
import java.awt.*;

public class Window extends JFrame {

    //Used for the this context
    int x, y, width, height;

    //Declarations for JFrame and JLabel
    protected static JLabel boardLabel;             //Label with the board image on it
    protected static JFrame frame = new JFrame();   //frame for containing Label + image in window

    //Window constructor - takes in width height and the title on top, all from Display
    Window(int width, int height, String title) {

        //CREATING WINDOW
        //Creating the window frame with title
        frame.setTitle(title);
        //Set window icon
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Graphics/Yay.jpeg")));
        //Ensures that window always stays the same dimensions, as set in Display
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        //Sets window in middle of screen, as opposed to top left by default
        frame.setLocationRelativeTo(null);
        //Ensures that the program quits when you hit (X)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ADDING BOARD
        Board.board(this);

        //ADDING BUTTONS
        Buttons.buttons(this);
    }


    /*//SETTERS AND GETTERS FOR FRAME AND LABEL
    public static JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame jfrm) {
        this.frame = jfrm;
    }

    public JLabel getBoardLabel() {
        return boardLabel;
    }

    public void setBoardLabel(JLabel jbL) {
        this.boardLabel = jbL;
    }*/
}


