import javafx.scene.control.TextInputDialog;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Optional;

//Window class is the class that makes the window, and controls the objects present on it
class Window extends JFrame {
    //Used for the this context
    public final Board board = new Board();

    //Window > JFrame > JPanel > JLabel
    //Declarations for JFrame
    //Frame for containing panel, label, and image in Window
    final JFrame frame = new JFrame();

    //JPanel to contain all die JLabels
    private final JPanel diePanel= new JPanel();

    JLabel dieLabel1_1;    //Label with player 1 Die 1 image on it
    JLabel dieLabel1_2;    //Label with player 1 Die 2 image on it
    JLabel dieLabel2_1;    //Label with player 2 Die 1 image on it
    JLabel dieLabel2_2;    //Label with player 2 Die 2 image on it
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

        //Creating window components
        //Creating dice
        Dice dice = new Dice(this);
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
        infoLabel.append(dice.getDice1());
        infoLabel.append(dice.getDice2());

        //Adding dice JLabels to JPanel, and then to JFrame - Still tweaking
        diePanel.setOpaque(true);
        diePanel.add(dieLabel1_1);  //Player 1 Dice 1
        diePanel.add(dieLabel1_2);  //Player 1 Dice 2
        diePanel.add(dieLabel2_1);  //Player 2 Dice 1
        diePanel.add(dieLabel2_2);  //Player 2 Dice 2


        //Adding components to JFrame
        //diePanel.setLayout(new BoxLayout(diePanel, BoxLayout.Y_AXIS));    //might need for positioning
        //Adding die JPanel to JFrame
        //frame.getContentPane().add(BorderLayout.CENTER, diePanel);
        //Adding board image to JFrame
        frame.getContentPane().add(BorderLayout.CENTER, board);
        //Adding info JLabel to JFrame
        frame.getContentPane().add(BorderLayout.LINE_START, infoLabel);
        frame.setVisible(true);

        //Player name getting
        JFrame p1frame = new JFrame("Player 1");
        JFrame p2frame = new JFrame("Player 2");
        String p1 = JOptionPane.showInputDialog(p1frame, "Player 1, please enter your name");
        String p2 = JOptionPane.showInputDialog(p2frame, "Player 2, please enter your name");
        Player player1 = new Player(p1);
        Player player2 = new Player(p2);
        infoLabel.append("\nWelcome to the game " + player1.getName() + ".");
        infoLabel.append("\nWelcome to the game " + player2.getName() + ".");

    }
}
