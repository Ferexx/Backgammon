//Java swing imports
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

//Java awt layouts
import java.awt.*;

//Window class is the class that makes the window, and controls the objects present on it
public class Window extends JFrame {

    //Used for the this context
    int x, y, width, height;
    public Board board = new Board(this);

    //WINDOW > JFRAME > JPANEL > JLABEL
    //Declarations for JFrame
    //FRAME FOR CONTAINING PANEL, LABEL + IMAGE IN WINDOW
    protected static JFrame frame = new JFrame();

    //JPANEL TO CONTAIN ALL DIE JLABELS
    protected static JPanel diePanel= new JPanel();

    protected static JLabel boardLabel;     //Label with the board image on it
    protected static JLabel dieLabel1_1;    //Label with player 1 Die 1 image on it
    protected static JLabel dieLabel1_2;    //Label with player 1 Die 2 image on it
    protected static JLabel dieLabel2_1;    //Label with player 2 Die 1 image on it
    protected static JLabel dieLabel2_2;    //Label with player 2 Die 2 image on it
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
        //CREATING DIE
        Dice.dice(this);
        //CREATING BUTTONS
        Buttons.buttons(this);

        //CREATING PLAYER-READABLE INFO TEXT BOX
        infoLabel = new JTextArea();
        infoLabel.setBorder(new EmptyBorder(20,20,20,20));
        infoLabel.setBounds(20,20,500,720);
        infoLabel.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        infoLabel.setBorder(border);
        commandHandler.restartText();
        infoLabel.append(Dice.getDice1());
        infoLabel.append(Dice.getDice2());

        //ADDING DICE JLABELS TO JPANEL, AND THEN TO JFRAME - STILL TWEAKING
        diePanel.setOpaque(true);
        diePanel.add(dieLabel1_1);  //Player 1 Dice 1
        diePanel.add(dieLabel1_2);  //Player 1 Dice 2
        diePanel.add(dieLabel2_1);  //Player 2 Dice 1
        diePanel.add(dieLabel2_2);  //Player 2 Dice 2


        //ADDING COMPONENTS TO JFRAME
        //diePanel.setLayout(new BoxLayout(diePanel, BoxLayout.Y_AXIS));    //might need for positioning
        frame.getContentPane().add(BorderLayout.CENTER, diePanel);  //STILL TWEAKING - alternatively might need for tweaking
        //ADDING BOARD JLABEL TO JFRAME
        frame.getContentPane().add(BorderLayout.LINE_END, boardLabel);
        //ADDING DIE JPANEL TO JFRAME
        frame.add(diePanel);
        //ADDING INFO JPANEL TO JFRAME
        frame.getContentPane().add(BorderLayout.LINE_START, infoLabel);
        //SETTING JFRAME TO VISIBLE
        frame.setVisible(true);
    }

}