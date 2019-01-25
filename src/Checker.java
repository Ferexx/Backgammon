import javax.swing.*;
import java.util.Random;

public class Checker {
    private String color;
    private ImageIcon image;
    JLabel checkerLabel = new JLabel();
    Random r = new Random();

    public Checker(String color) {
        setColor(color);
    }

    public void setColor(String color) {
        this.color = color;
        if (this.color=="White") {
            image = new ImageIcon(getClass().getResource("Graphics/WhiteChecker.png"));
            checkerLabel.setIcon(image);
        }
        if (this.color=="Black") {
            image = new ImageIcon(getClass().getResource("Graphics/BlackChecker.png"));
            checkerLabel.setIcon(image);
        }
        if (this.color=="Lime") {
            image = new ImageIcon(getClass().getResource("Graphics/LimeChecker.png"));
            checkerLabel.setIcon(image);
        }
        if (this.color=="Purple") {
            image = new ImageIcon(getClass().getResource("Graphics/PurpleChecker.png"));
            checkerLabel.setIcon(image);
        }
        if (this.color=="Red") {
            image = new ImageIcon(getClass().getResource("Graphics/RedChecker.png"));
            checkerLabel.setIcon(image);
        }
    }
    public JLabel getCheckerLabel() {
        return checkerLabel;
    }
}
