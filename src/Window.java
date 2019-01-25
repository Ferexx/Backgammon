import javafx.event.ActionEvent;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private ImageIcon image, image2;
    private ImageView image;
    private JLabel label, label2;
    JFrame frame = new JFrame();

    Window(int width, int height, String title) {
        frame.setTitle(title);
        getContentPane().setBackground(Color.BLACK);
        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        label = new JLabel(image);
        label.setHorizontalAlignment(SwingConstants.RIGHT);     //Position in bottom right
        label.setVerticalAlignment(SwingConstants.BOTTOM);
        //Broken but basic concept
        //JTextField textField = new JTextField("Test", 20);
        //frame.add(textField);
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
        System.out.println("You entered " + text1); //printing this to console too for the time being
    }
    public void addChecker(ImageIcon image) {
        label2 = new JLabel(image);
        frame.add(label2);
    }
}

