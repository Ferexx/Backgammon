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

    //Window > JFrame > JPanel > JLabel
    //Declarations for JFrame
    //Frame for containing panel, label, and image in Window
    protected JFrame frame = new JFrame();

    //JPanel to contain all die JLabels
    protected JPanel diePanel= new JPanel();

    public JLabel boardLabel;     //Label with the board image on it
    protected JLabel dieLabel1_1;    //Label with player 1 Die 1 image on it
    protected JLabel dieLabel1_2;    //Label with player 1 Die 2 image on it
    protected  JLabel dieLabel2_1;    //Label with player 2 Die 1 image on it
    protected JLabel dieLabel2_2;    //Label with player 2 Die 2 image on it
    protected JTextArea infoLabel;   //Label with info text area

    //Window constructor
    Window(int width, int height, String title, commandHandler commands) {

        //Creating the window frame with title
        frame.setTitle(title);
        //Set window icon
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Yay.jpeg")));
        //Ensures that window always stays the same dimensions
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        //Sets window in middle of screen, as opposed to top left by default
        frame.setLocationRelativeTo(null);
        //Ensures that the program quits when you hit (X)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating window components
        //Creating dice
        new Dice(this);
        //Creating Buttons
        new Buttons(this);

        //Creating player-readable text info box
        infoLabel = new JTextArea();
        infoLabel.setBorder(new EmptyBorder(20,20,20,20));
        infoLabel.setBounds(20,20,500,720);
        infoLabel.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        infoLabel.setBorder(border);
        commands.restartText(this);
        infoLabel.append(Dice.getDice1());
        infoLabel.append(Dice.getDice2());

        //Adding dice JLabels to JPanel, and then to JFrame - Still tweaking
        diePanel.setOpaque(true);
        diePanel.add(dieLabel1_1);  //Player 1 Dice 1
        diePanel.add(dieLabel1_2);  //Player 1 Dice 2
        diePanel.add(dieLabel2_1);  //Player 2 Dice 1
        diePanel.add(dieLabel2_2);  //Player 2 Dice 2


        //Adding components to JFrame
        //diePanel.setLayout(new BoxLayout(diePanel, BoxLayout.Y_AXIS));    //might need for positioning
        frame.getContentPane().add(BorderLayout.CENTER, diePanel);  //STILL TWEAKING - alternatively might need for tweaking
        //Adding board JLabel to JFrame
        frame.getContentPane().add(BorderLayout.LINE_END, boardLabel);
        //Adding die JPanel to JFrame
        frame.add(diePanel);
        //Adding info JLabel to JFrame
        frame.getContentPane().add(BorderLayout.LINE_START, infoLabel);
        frame.setVisible(true);
    }
}