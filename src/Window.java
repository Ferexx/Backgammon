import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

//Window class is the class that makes the window, and controls the objects present on it
class Window extends JFrame {
    public final Drawing drawing = new Drawing(this);
    public Dice dice1 = new Dice();
    public Dice dice2 = new Dice();

    //Window > JFrame > JPanel > JLabel
    //Declarations for JFrame
    //Frame for containing panel, label, and image in Window
    final JFrame frame = new JFrame();

    //JPanel to contain all die JLabels
    final JTextArea infoLabel;   //Label with info text area

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
        frame.setLayout(new BorderLayout());

        //Creating Buttons
        new Buttons(this);

        //Creating player-readable text info box
        infoLabel = new JTextArea();
        infoLabel.setBorder(new EmptyBorder(20,20,20,20));
        infoLabel.setBounds(20,20,500,720);
        infoLabel.setPreferredSize(new Dimension(255,720));
        infoLabel.setEditable(false);
        infoLabel.setLineWrap(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        infoLabel.setBorder(border);
        commands.restartText(this);
        //TODO
        //infoLabel.append(dice1.getDice1());
        //infoLabel.append(dice2.getDice2());

        //Adding components to JFrame
        //Adding info JLabel to JFrame
        frame.getContentPane().add(BorderLayout.LINE_START, infoLabel);


        frame.setVisible(true);
    }
}
