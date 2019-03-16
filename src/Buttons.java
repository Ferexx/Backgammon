import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Buttons {

    /*int player1Set = 0;
    int player2Set = 1;*/

    private JTextField textField;

    private commandHandler commands = new commandHandler();

    //action listener for enter button
    private void enterPerformed(ActionEvent e) {
    }

    //action listener for reset button
    private void resetPerformed(ActionEvent e, Window window) {
        commands.restartText(window);
        PointStorage.initPoints();
        window.drawing.update();
    }

    //Catches when enter is performed (either by button or keypress) and saves the command entered to a string, passed to our commandHandler.
    private void enterCommandPerformed(ActionEvent e, Window window) {

        String command = textField.getText();
        System.out.println("Command = " + command);
        textField.setText(null);
        commands.appendText(command, window);
        /*player1Set = 1;
        player2Set = 1;*/
    }

    //MAKING BUTTONS
    public Buttons(Window window){

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
            public void actionPerformed(ActionEvent e) { resetPerformed(e, window); }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { resetPerformed(e, window); }
        });

        //Listener that we can attach to both a keypress of enter and pressing the enter key.
        Action enterCommand = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { enterCommandPerformed(e, window); }
        };
        //Adding action listeners for both.
        textField.addActionListener(enterCommand);
        enter.addActionListener(enterCommand);

        //Adding these interfaces to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(enter);
        panel.add(reset);

        window.mainFrame.getContentPane().add(BorderLayout.SOUTH, panel);
        window.mainFrame.getContentPane().add(BorderLayout.NORTH, mb);

    }
}