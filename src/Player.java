class Player {
    private String PlayerName;
    private String colour;
    private int score;

    public Player() {}

    public void setName(String name)
    {
        this.PlayerName = name;
    }

    public void setChecker(String checkerColour)
    {
        this.colour = checkerColour;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName()
    {
        return PlayerName;
    }

    public String getColour()
    {
        return colour;
    }

    public int getScore() {
        return score;
    }

}
