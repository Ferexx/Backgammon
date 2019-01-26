import javax.swing.*;
import java.awt.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;

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
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter command");
        JTextField tf = new JTextField(20); // accepts upto 10 characters
        JButton send = new JButton("Enter");
        //Maybe a button to clear the command field? We can just do away with this either, the command field only allows 20 characters anyway.
        JButton reset = new JButton("Reset");

        //Add panel stuff
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, bglabel);

        frame.setVisible(true);
    }
}

