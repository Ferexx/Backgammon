import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private ImageIcon image;
    private JLabel label;

    Window(int width, int height, String title) {
        JFrame frame = new JFrame(title);
        getContentPane().setBackground(Color.BLACK);
        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        label = new JLabel(image);
        label.setHorizontalAlignment(SwingConstants.RIGHT);     //Position in bottom right
        label.setVerticalAlignment(SwingConstants.BOTTOM);
        frame.add(label);
        frame.setPreferredSize(new Dimension(width, height)); //Ensuring the window always stays the same size
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //Below needs to be encapsulated into an if statement for teams.
        JTextField txt = new JTextField("");
        String text1;
        text1 = JOptionPane.showInputDialog("Enter command");
        JOptionPane.showMessageDialog(null, "You entered " + text1 , "Enter command", JOptionPane.PLAIN_MESSAGE );
        System.out.print(text1);
    }
}

