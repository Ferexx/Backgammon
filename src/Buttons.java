import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
public class Buttons {

    //MAKING BUTTONS
    public static void buttons(final Window window){
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
        Window.frame.getContentPane().add(BorderLayout.SOUTH, panel);
        Window.frame.getContentPane().add(BorderLayout.NORTH, mb);
        Window.frame.getContentPane().add(BorderLayout.EAST, window.boardLabel);
        Window.frame.setVisible(true);
    }

    public static void enterperfomed(ActionEvent e) {

        //Draws first checker when enter button is pressed - temporary measure for now
        Graphics graphics = Window.boardLabel.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
        Ellipse2D.Double Window = new Ellipse2D.Double(662, 535, 40, 40);
        g.setColor(Color.BLACK);
        g.fill(Window);
    }
}