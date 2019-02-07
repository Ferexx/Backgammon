import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {

    protected static JTextField textField = new JTextField();

    //action listener for enter button
    public static void enterPerformed(ActionEvent e) {

    }

    //action listener for reset button
    public static void resetPerformed(ActionEvent e) {
        commandHandler.restartText();
    }

    //Catches when enter is performed (either by button or keypress) and saves the command entered to a string, passed to our commandHandler.
    public static void enterCommandPerformed(ActionEvent e) {
        String command = textField.getText();
        System.out.println("Command = " + command);
        textField.setText(null);
        commandHandler.appendText(command);
    }

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
        JMenuItem m11 = new JMenuItem("New game");
        JMenuItem m12 = new JMenuItem("Save winner");
        JMenuItem m13 = new JMenuItem("Reset game");
        //adding menu button options
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);

        //USER INTERACTION WITH BOARD OPTIONS
        JPanel panel = new JPanel();
        //label for user commands
        JLabel label = new JLabel("Enter Command");


        //Text field accepts up to 20 characters
        textField = new JTextField(20);
        JButton enter = new JButton("Enter");
        JButton reset = new JButton("Reset");

        //Action Listener for New Game Option
        //New Game places the checkers in starting positions
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { enterPerformed(e); }
        });

        //Listener to reset the game. Only resets text currently.
        m13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { resetPerformed(e); }
        });

        //Listener that we can attach to both a keypress of enter and pressing the enter key.
        Action enterCommand = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { enterCommandPerformed(e); }
        };
        //Adding action listeners for both.
        textField.addActionListener(enterCommand);
        enter.addActionListener(enterCommand);


        //Adding these interfaces to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(enter);
        panel.add(reset);

        Window.frame.getContentPane().add(BorderLayout.SOUTH, panel);
        Window.frame.getContentPane().add(BorderLayout.NORTH, mb);
    }
}