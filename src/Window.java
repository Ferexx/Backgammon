import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;

import java.awt.Dimension;

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
        frame.add(label);
        frame.setPreferredSize(new Dimension(width, height)); //Ensuring the window always stays the same size
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public void addChecker(ImageIcon image) {
        label2 = new JLabel(image);
        frame.add(label2);
    }
}
