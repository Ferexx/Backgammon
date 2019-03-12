import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;

//Window class is the class that makes the window, and controls the objects present on it
class Window extends JFrame {
    public final Drawing drawing = new Drawing(this);
    public Dice dice1_1 = new Dice(this);
    public Dice dice1_2 = new Dice(this);
    public Dice dice2_1 = new Dice(this);
    public Dice dice2_2 = new Dice(this);

    //Window > JFrame > JPanel > JLabel
    //Declarations for JFrame
    //Frame for containing panel, label, and image in Window
    final JFrame nameFrame = new JFrame();
    final JFrame mainFrame = new JFrame();
    private JTextField nameField1;
    private JTextField nameField2;
    //JPanel to contain all die JLabels
    final JTextArea infoLabel = new JTextArea();   //Label with info text area

    //Window constructor
    Window() {
        nameFrame.setTitle("Player Name Entry");
        nameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Yay.jpeg")));
        nameFrame.setPreferredSize(new Dimension(500,300));
        nameFrame.setMaximumSize(new Dimension(500,300));
        nameFrame.setMinimumSize(new Dimension(500,300));
        nameFrame.setResizable(false);
        nameFrame.setLocationRelativeTo(null);

        //Name fields
        JPanel nameContainer = new JPanel();
        nameContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        nameContainer.setLayout(new BorderLayout());

        nameField1 = new JTextField(10);
        nameField2 = new JTextField(10);
        nameContainer.add(nameField1, BorderLayout.WEST);
        nameContainer.add(nameField2, BorderLayout.EAST);
        nameFrame.getContentPane().add(BorderLayout.SOUTH, nameContainer);
        nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        nameFrame.setVisible(true);
    }
    Window(int width, int height, String title, commandHandler commands) {
        //Creating the window mainFrame with title
        mainFrame.setTitle(title);
        //Set window icon
        mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resources/Yay.jpeg")));
        //Ensures that window always stays the same dimensions
        mainFrame.setPreferredSize(new Dimension(width, height));
        mainFrame.setMaximumSize(new Dimension(width, height));
        mainFrame.setMinimumSize(new Dimension(width, height));
        mainFrame.setResizable(false);
        //Sets window in middle of screen, as opposed to top left by default
        mainFrame.setLocationRelativeTo(null);
        //Ensures that the program quits when you hit (X)
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        //Creating Buttons
        new Buttons(this);

        //Creating player-readable text info box
        JScrollPane scrollPane = new JScrollPane(infoLabel);
        scrollPane.setBorder(new EmptyBorder(20,20,20,20));
        scrollPane.setBounds(20,20,255,600);
        scrollPane.setPreferredSize(new Dimension(255,600));

        DefaultCaret caret = (DefaultCaret)infoLabel.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        infoLabel.setEditable(false);
        infoLabel.setLineWrap(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        scrollPane.setBorder(border);
        commands.restartText(this);
        //Adding info JLabel to JFrame
        mainFrame.getContentPane().add(BorderLayout.LINE_START, scrollPane);
        mainFrame.setVisible(false);
    }
}
