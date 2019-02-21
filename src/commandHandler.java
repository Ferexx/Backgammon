class commandHandler {

    private String p1Name = "";
    private String p2Name = "";

    public commandHandler() {}
    //Handler for catching events. We'll catch strings, find their meaning then convert them to actual appendages using if statements.
    public void appendText(String text, Window window) {
        if(text.equalsIgnoreCase("quit")) {
            catchQuit();
        }
        if(text.equalsIgnoreCase("1 3")) {
            //Window.board.move(Controller.pointList[0], Controller.pointList[2]);
        }

        //Testing and debug
        else {
            window.infoLabel.append("\n" + text);
        }

    }

    //Used for restarting the game
    public void restartText(Window window) {
        window.infoLabel.setText(null);
        window.infoLabel.setText("Welcome to Backgammon!\nBy Evin Kierans, Jack Price, Adam Conway.\n\n");
        window.infoLabel.append("\nPlayer 1, please enter your name.");

    }

    //Quits
    private void catchQuit() {
        System.exit(0);
    }
}
