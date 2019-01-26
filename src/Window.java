import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Window extends JFrame {
    private ImageIcon image;
    private JLabel bglabel;
    static JFrame frame = new JFrame();

    Window(int width, int height, String title) {
        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(width, height)); //Ensuring the window always stays the same size
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create menubar at top
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Save winner");
        JMenuItem m12 = new JMenuItem("Reset game");
        m1.add(m11);
        m1.add(m12);

        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        bglabel = new JLabel(image);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter command");
        JTextField textfield = new JTextField(20); // accepts up to 20 characters
        JButton enter = new JButton("Enter");
        //Maybe a button to clear the command field? We can just do away with this either, the command field only allows 20 characters anyway.
        JButton reset = new JButton("Reset");

        //Action listeners for buttons, messy
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterperfomed(e);
            }
        });

        //Add panel stuff
        panel.add(label);
        panel.add(textfield);
        panel.add(enter);
        panel.add(reset);

        //Adding Components to the frame and padding for the backgammon board.
        bglabel.setBorder( new EmptyBorder( 16, 16, 16, 64 ) );
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.EAST, bglabel);

        frame.setVisible(true);
    }

    //Used for the this context
    int x, y, width, height;


    //Graphics for drawing a circle, also messy.
    public void enterperfomed(ActionEvent e)
    {
        Graphics graphics = bglabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window = new Ellipse2D.Double(x, y, 10, 10);
        g.setColor(Color.BLACK);
        g.fill(Window);
    }


    //Calculates X Y coordinates of where to place the circles.
    public Window(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

