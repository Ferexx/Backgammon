import javax.swing.*;

public class Checker {
    private String color;
    private ImageIcon image;
    private JLabel label;

    public Checker(String color, Window window) {
        setColor(color, window);
    }

    public void setColor(String color, Window window) {
        this.color = color;
        if (this.color=="White") {
            image = new ImageIcon("Graphics/WhiteChecker.png");
            label = new JLabel(image);
        }
        if (this.color=="Black") {
            image = new ImageIcon("Graphics/BlackChecker.png");
            label = new JLabel(image);
        }
        if (this.color=="Lime") {
            image = new ImageIcon("Graphics/LimeChecker.png");
            label = new JLabel(image);
        }
        if (this.color=="Purple") {
            image = new ImageIcon("Graphics/PurpleChecker.png");
            label = new JLabel(image);
        }
        if (this.color=="Red") {
            image = new ImageIcon(getClass().getResource("Graphics/RedChecker.png"));
            label = new JLabel(image);
        }
        System.out.println("Hello ther");
        window.addChecker(image);
    }
    public String getColor() {
        return this.color;
    }
}
