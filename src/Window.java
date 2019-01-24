import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private ImageIcon image;
    private JLabel label;

    Window() {
        getContentPane().setBackground(Color.BLACK);
        image = new ImageIcon(getClass().getResource("Graphics/SmallBoard.png"));
        label = new JLabel(image);
        label.setHorizontalAlignment(SwingConstants.RIGHT);     //Position in bottom right
        label.setVerticalAlignment(SwingConstants.TOP);
        add(label);
        setPreferredSize(new Dimension(1100, 800)); //Ensuring the window always stays the same size
        setMaximumSize(new Dimension(1100, 800));
        setMinimumSize(new Dimension(1100, 800));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}

