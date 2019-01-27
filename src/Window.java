//Java swing imports
import javax.swing.border.EmptyBorder;
import javax.swing.*;

//Java awt layouts
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.*;

public class Window extends JFrame {

    //Hello what doink these are not used blyat someone explique pour moi and why were they not up top
    //Used for the this context
    int x, y, width, height;

    //Declarations for JFrame, JLabel, and ImageIcon
    private ImageIcon image;
    private JLabel boardLabel;
    static JFrame frame = new JFrame();

    //Declarations for x-axis coordinates for the checker positions
    int[] pointXCoords = new int[]{72, 122, 171, 221, 271, 321, 413, 463, 513, 563, 612, 662};

    //Window constructor - takes in width height and the title on top, all from Display
    Window(int width, int height, String title) {

        //CREATING WINDOW
        //Creating the window frame with title
        frame.setTitle(title);
        //Ensures that window always stays the same dimensions, as set in Display
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        //Ensures that the program quits when you hit (X)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //MAKING BOARD
        board();

        //ADDING BUTTONS
        buttons();
    }

    //METHOD FOR MAKING CHECKER APPEAR
    //Graphics for drawing a circle, also messy.
    public void enterperfomed(ActionEvent e) {

        //Draws first checker when enter button is pressed - temporary measure for now
        Graphics graphics = boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window = new Ellipse2D.Double(662, 535, 40, 40);
        g.setColor(Color.BLACK);
        g.fill(Window);
    }

    //MAKING BOARD A REALITY
    public void board(){
        Board board = new Board();//sets the board onto the screen from the graphics folder
        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        //Giving the board a padding border
        boardLabel = new JLabel(image);
        boardLabel.setBorder(new EmptyBorder( 16, 16, 16, 64 ) );
    }

    //MAKING BUTTONS
    public void buttons(){
        //All button creation from Window.java will be in here soon
        //MENU BAR BUTTONS AND BUTTON OPTIONS
        JMenuBar mb = new JMenuBar();
        //defining menu buttons
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        //adding menu buttons
        mb.add(m1);
        mb.add(m2);
        //defining menu button options
        JMenuItem m11 = new JMenuItem("Save winner");
        JMenuItem m12 = new JMenuItem("Reset game");
        //adding menu button options
        m1.add(m11);
        m1.add(m12);

        //USER INTERACTION WITH BOARD OPTIONS
        JPanel panel = new JPanel();
        //label for user commands
        JLabel label = new JLabel("Enter Command");
        //Text field accepts up to 20 characters
        JTextField textfield = new JTextField(20);
        JButton enter = new JButton("Enter");
        JButton reset = new JButton("Reset");

        //Action listeners for buttons, messy
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { enterperfomed(e); }
        });

        //Adding these interfaces to the panel
        panel.add(label);
        panel.add(textfield);
        panel.add(enter);
        panel.add(reset);

        //Adding Components to the frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.EAST, boardLabel);
        frame.setVisible(true);
    }
}


