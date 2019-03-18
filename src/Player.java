class Player {
    private String PlayerName;
    private String colour;

    public Player() {}

    public void setName(String name)
    {
        this.PlayerName = name;
    }

    public void setChecker(String checkerColour)
    {
        this.colour = checkerColour;
    }

    public String getName()
    {
        return PlayerName;
    }

    public String getColour()
    {
        return colour;
    }

}
