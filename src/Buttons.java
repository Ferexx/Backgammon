import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Buttons {

    private final JTextField textField;

    private final commandHandler commands = new commandHandler();

    final JTextArea helpField = new JTextArea();

    //action listener for enter button
    private void enterPerformed() {
    }

    //action listener for reset button
    private void resetPerformed(Window window) {
        commandHandler.restartGame(window);
    }

    private void help(Window window)
    {
        System.out.println("test");
        JFrame helpFrame = new JFrame("Help");
        helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        helpFrame.getContentPane().add(helpField, BorderLayout.CENTER);
        helpFrame.pack();
        helpFrame.setPreferredSize(new Dimension(500,300));
        helpFrame.setMaximumSize(new Dimension(500,300));
        helpFrame.setMinimumSize(new Dimension(500,300));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        helpField.setBorder(border);
        helpField.setEditable(false);
        helpField.setLineWrap(true);
        helpField.setWrapStyleWord(true);
        helpField.setText("\nPlease input moves as either a single character, or two numbers separated by a space, with the first number being the point you wish to move a checker from, and the second being the point you wish to move a checker to. In the case of a bar move, enter \"BAR\" followed by the point you wish to move to, separated by a space. In the case of bearing off, please enter the point you wish to move a checker from, followed by \"OFF\", again separated by a space.");
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setVisible(true);
    }

    //Catches when enter is performed (either by button or keypress) and saves the command entered to a string, passed to our commandHandler.
    private void enterCommandPerformed(Window window) {
        System.out.println("Command = " + textField.getText());
        commands.appendText(textField.getText(), window);
        textField.setText(null);
    }

    //MAKING BUTTONS
    public Buttons(Window window){

        //MENU BAR BUTTONS AND BUTTON OPTIONS
        JMenuBar mb = new JMenuBar();
        //defining menu buttons
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Other");
        //adding menu buttons
        mb.add(m1);
        mb.add(m2);
        //defining menu button options
        JMenuItem m11 = new JMenuItem("New game");
        JMenuItem m12 = new JMenuItem("Save winner");
        JMenuItem m13 = new JMenuItem("Reset game");
        JMenuItem m21 = new JMenuItem("Help");
        //adding menu button options
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m2.add(m21);

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
            public void actionPerformed(ActionEvent e) { enterPerformed(); }
        });

        //Listener to reset the game. Only resets text currently.
        m13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { resetPerformed(window); commandHandler.restartGame(window);}
        });

        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { help(window); }
        });



        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { resetPerformed(window); commandHandler.restartGame(window);}
        });

        //Listener that we can attach to both a keypress of enter and pressing the enter key.
        Action enterCommand = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { enterCommandPerformed(window); }
        };
        //Adding action listeners for both.
        textField.addActionListener(enterCommand);
        enter.addActionListener(enterCommand);

        //Adding these interfaces to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(enter);
        panel.add(reset);

        window.frame.getContentPane().add(BorderLayout.SOUTH, panel);
        window.frame.getContentPane().add(BorderLayout.NORTH, mb);

    }
}