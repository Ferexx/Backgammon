//Java swing imports
import javax.swing.*;

//Java awt layouts
import java.awt.*;

public class Window extends JFrame {

    //Used for the this context
    int x, y, width, height;

    //WINDOW > JFRAME > JPANEL > JLABEL
    //Declarations for JFrame, JPanel and JLabel
    //FRAME FOR CONTAINING LABEL + IMAGE IN WINDOW
    protected static JFrame frame = new JFrame();

    //JPANEL TO CONTAIN ALL DIE JLABELS
    protected static JPanel diePanel= new JPanel();

    protected static JLabel boardLabel;     //Label with the board image on it
    protected static JLabel dieLabel1_1;    //Label with the Die image on it
    protected static JLabel dieLabel1_2;    //Label with the Die image on it
    protected static JLabel dieLabel2_1;    //Label with the Die image on it
    protected static JLabel dieLabel2_2;    //Label with the Die image on it
    protected static JTextArea infoLabel;   //Label with info text area

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

        //CREATING WINDOW COMPONENTS
        //CREATING BOARD
        Board.board(this);
        //CREATING DIE
        Dice.dice(this);
        //CREATING BUTTONS
        Buttons.buttons(this);
        //CREATING TEXT BOX
        JTextArea info = new JTextArea("Welcome to Backgammon!");
        info.setBounds(20,20,300,500);

        //ADDING DICE JLABELS TO JPANEL, AND THEN TO JFRAME - STILL TWEAKING
        diePanel.setOpaque(true);
        diePanel.add(dieLabel1_1);  //Player 1 Dice 1
        diePanel.add(dieLabel1_2);  //Player 1 Dice 2
        diePanel.add(dieLabel2_1);  //Player 2 Dice 1
        diePanel.add(dieLabel2_2);  //Player 2 Dice 2

        //ADDING COMPONENTS TO JFRAME
        //diePanel.setLayout(new BoxLayout(diePanel, BoxLayout.Y_AXIS));    //might need for positioning
        Window.frame.getContentPane().add(BorderLayout.CENTER, Window.diePanel);  //STILL TWEAKING - alternatively might need for tweaking
        //ADDING BOARD JLABEL TO JFRAME
        Window.frame.getContentPane().add(BorderLayout.LINE_END, Window.boardLabel);
        //ADDING DIE JPANEL TO JFRAME
        Window.frame.add(diePanel);
        //ADDING INFO JPANEL TO JFRAME
        Window.frame.getContentPane().add(BorderLayout.LINE_START, info);
        //SETTING JFRAME TO VISIBLE
        Window.frame.setVisible(true);
    }
}