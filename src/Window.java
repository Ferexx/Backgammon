//Java swing imports
import javax.swing.*;

//Java awt layouts
import java.awt.*;

public class Window extends JFrame {

    //Used for the this context
    int x, y, width, height;

    //Declarations for JFrame and JLabel
    protected static JLabel boardLabel;             //Label with the board image on it
    protected static JLabel dieLabel1;             //Label with the Die image on it
    protected static JLabel dieLabel2;              //Label with the Die image on it
    protected static JTextArea infoLabel;
    protected static JFrame frame = new JFrame();   //frame for containing Label + image in window

    //Window constructor - takes in width height and the title on top, all from Display
    Window(int width, int height, String title) {

        //CREATING WINDOW
        //Creating the window frame with title
        frame.setTitle(title);
        //Set window icon
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Yay.jpeg")));
        //Ensures that window always stays the same dimensions, as set in Display
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        //Sets window in middle of screen, as opposed to top left by default
        frame.setLocationRelativeTo(null);
        //Ensures that the program quits when you hit (X)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ADDING WINDOW COMPONENTS
        //ADDING BOARD
        Board.board(this);

        //ADDING DIE
        Dice.drawDice(this);

        //ADDING BUTTONS
        Buttons.buttons(this);

        //ADDING TEXT
        JTextArea info = new JTextArea("Welcome to Backgammon!");
        info.setBounds(20,20,300,500);
        add(info);

        //Adding Components to the frame and positioning them
        Window.frame.getContentPane().add(BorderLayout.EAST, Window.boardLabel);
        Window.frame.getContentPane().add(BorderLayout.CENTER, Window.dieLabel1);
        Window.frame.getContentPane().add(BorderLayout.CENTER, Window.dieLabel2);
        Window.frame.getContentPane().add(BorderLayout.WEST, info);
        Window.frame.setVisible(true);
    }

}