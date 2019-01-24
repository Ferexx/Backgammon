import javax.swing.*;
import java.awt.*;

import java.awt.Dimension;

public class Window extends JFrame {
    private ImageIcon image;
    private JLabel label;

    Window(int width, int height, String title) {
        getContentPane().setBackground(Color.BLACK);
        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        label = new JLabel(image);
        label.setHorizontalAlignment(SwingConstants.RIGHT);     //Position in bottom right
        label.setVerticalAlignment(SwingConstants.TOP);
        add(label);
        setPreferredSize(new Dimension(width, height)); //Ensuring the window always stays the same size
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}

