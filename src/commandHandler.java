public class commandHandler {

    //Handler for catching events. We'll catch strings, find their meaning then convert them to actual appendages using if statements.
    public static void appendText(String text) {
        if(text.equalsIgnoreCase("quit")) {
            catchQuit();
        }
        if(text.equalsIgnoreCase("demo")) {
            Controller.demoCheckers();
        }
        //Testing and debug
        else {
            Window.infoLabel.append("\n" + text);

        }
    }

    //Used for restarting the game
    public static void restartText() {
        Window.infoLabel.setText(null);
        Window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Cobwag.\n\n");
    }

    //Quits
    private static void catchQuit() {
        System.exit(0);
    }
}
