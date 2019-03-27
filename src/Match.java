import java.awt.*;

public class Match {
    public static int numberOfMatches;
    public static int currentMatch=0;
    private int playerWon=0;

    public void setPlayerWon(int won) {
        this.playerWon=won;
    }
    public int getPlayerWon() {
        return this.playerWon;
    }

    public static void drawMatches(Graphics2D g) {
        for(int i=0;i<numberOfMatches;i++) {
            g.setColor(Color.BLACK);
            g.fillOval(950-(i*25), 0, 20, 20);
            if(Game.matchList[i].getPlayerWon()==0) {
                g.setColor(Color.WHITE);
                g.fillOval(952-(i*25), 2, 16, 16);
            }
            if(Game.matchList[i].getPlayerWon()==1) {
                g.setColor(Color.RED);
                g.fillOval(952-(i*25), 2, 16, 16);
            }
            if(Game.matchList[i].getPlayerWon()==2) {
                g.setColor(Color.BLACK);
                g.fillOval(950-(i*25), 0, 20, 20);
            }
        }
    }
}