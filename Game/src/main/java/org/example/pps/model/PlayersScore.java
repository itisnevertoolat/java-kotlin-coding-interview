package org.example.pps.model;

public class PlayersScore {
    private int playerAScore;
    private int playerBScore;
    private int drawScore;

    public int getPlayerAScore() {
        return playerAScore;
    }

    public void increasePlayerAScore() {
        this.playerAScore++;
    }

    public int getPlayerBScore() {
        return playerBScore;
    }

    public void increasePlayerBScore() {
        this.playerBScore++;
    }

    public int getDrawScore() {
        return drawScore;
    }

    public void increaseDrawScore() {
        this.drawScore++;
    }
}
