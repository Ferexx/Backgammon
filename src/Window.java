//Java swing imports
import javax.swing.*;

//Java awt layouts
import java.awt.*;

public class Window extends JFrame {

    //Used for the this context
    int x, y, width, height;

    //Declarations for JFrame and JLabel
    protected static JFrame frame = new JFrame();   //frame for containing Label + image in window

    protected static JPanel diePanel= new JPanel(); //Adding new diePanel for 2 dieLabels

    protected static JLabel boardLabel;             //Label with the board image on it
    protected static JLabel dieLabel1;              //Label with the Die image on it
    protected static JLabel dieLabel2;              //Label with the Die image on it
    protected static JTextArea infoLabel;

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

        //ADDING DICE TO JPANEL TO JFRAME - STILL TWEAKING
        diePanel.setOpaque(true);
        diePanel.add(dieLabel1);
        diePanel.add(dieLabel2);
        frame.add(diePanel);
        //diePanel.setLayout(new BoxLayout(diePanel, BoxLayout.Y_AXIS));

        //Adding Components to the frame and positioning them
        Window.frame.getContentPane().add(BorderLayout.LINE_END, Window.boardLabel);
        //Window.frame.getContentPane().add(BorderLayout.CENTER, Window.diePanel);  //STILL TWEAKING
        Window.frame.add(diePanel);
        Window.frame.getContentPane().add(BorderLayout.LINE_START, info);
        Window.frame.setVisible(true);
    }

}