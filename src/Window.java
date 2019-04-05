import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




//Window class is the class that makes the window, and controls the objects present on it
class Window extends JFrame {



    public final Drawing drawing = new Drawing(this);
    public final Dice p1D1 = new Dice(86, 120);
    public final Dice p1D2 = new Dice(140, 166);
    public final Dice p2D1 = new Dice(86, 420);
    public final Dice p2D2 = new Dice(140, 466);
    public static final Timer timer = new Timer();

    //Window > JFrame > JPanel > JLabel
    //Declarations for JFrame
    //Frame for containing panel, label, and image in Window
    private final JFrame nameFrame = new JFrame();
    final JFrame mainFrame = new JFrame();
    //JPanel to contain all die JLabels
    final JTextArea infoLabel = new JTextArea();   //Label with info text area

    //Window for getting names constructor
    Window() {
        //Setting up window elements
        JLabel player1 = new JLabel("Player 1 Name:");
        JLabel player2 = new JLabel("Player 2 Name:");
        JLabel points = new JLabel("Number of points to be played:");
        JTextField nameField1 = new JTextField(10);
        JTextField nameField2 = new JTextField(10);
        JTextField pointsField = new JTextField(10);
        JLabel error = new JLabel("Please enter names for both players!");
        JButton goButton = new JButton("Go!");
        nameFrame.setTitle("Player Name Entry");
        nameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/Images/Yay.jpeg")));
        nameFrame.setPreferredSize(new Dimension(500,300));
        nameFrame.setMaximumSize(new Dimension(500,300));
        nameFrame.setMinimumSize(new Dimension(500,300));
        nameFrame.setResizable(false);
        nameFrame.setLocationRelativeTo(null);


        //Name fields
        JPanel nameContainer = (JPanel) nameFrame.getContentPane();
        nameFrame.setLayout(null);
        nameContainer.setLayout(null);

        //Positioning everything
        nameField1.setBounds(200,40,200,30);
        nameField2.setBounds(200,90,200,30);
        pointsField.setBounds(200, 140, 200, 30);
        error.setBounds(150,5, 300, 30);
        player1.setBounds(100,40,100,30);
        player2.setBounds(100,90,100,30);
        points.setBounds(15, 140, 200, 30);
        goButton.setBounds(200,200, 60, 40);
        nameContainer.add(nameField1);
        nameContainer.add(nameField2);
        nameContainer.add(pointsField);
        nameContainer.add(player1);
        nameContainer.add(player2);
        nameContainer.add(points);
        nameContainer.add(goButton);
        nameContainer.add(error);
        error.setVisible(false);
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //If text has been entered in both fields
                if (!nameField1.getText().isEmpty() && !nameField2.getText().isEmpty()) {
                    commandHandler.player1.setName(nameField1.getText());
                    commandHandler.player2.setName(nameField2.getText());
                    commandHandler.finalScore=Integer.parseInt(pointsField.getText());
                    nameFrame.setVisible(false);
                    //Close current window and move to main window
                    nameFrame.dispose();
                    Game.mainFrame = true;
                } else {
                    error.setVisible(true);
                }
            }
        });

        nameContainer.getRootPane().setDefaultButton(goButton);

        nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameFrame.pack();
        nameFrame.setVisible(true);
    }

    //Main window constructor
    Window(int width, int height, String title, commandHandler commands) {
        //Creating the window mainFrame with title
        mainFrame.setTitle(title);
        //Set window icon
        mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/Images/Yay.jpeg")));
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
        infoLabel.setWrapStyleWord(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        scrollPane.setBorder(border);
        commands.restartText(this);
        //Adding info JLabel to JFrame
        mainFrame.getContentPane().add(BorderLayout.LINE_START, scrollPane);
        mainFrame.setVisible(true);
        commandHandler.setNames(this);
    }
}
