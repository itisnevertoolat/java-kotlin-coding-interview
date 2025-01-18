package org.example.pps.service;

import org.example.pps.enums.*;
import org.example.pps.model.PlayersScore;

import java.util.Random;

public class GameServiceImpl implements GameService {
    public PlayersScore playersScore = new PlayersScore();
    public Random random = new Random();

    @Override
    public void play() {

        Signs playerASign = getRandomSigns();
        Signs playerBSign = Signs.ROCK;
        Result result = getTheResult(playerASign, playerBSign);
        changePlayersScore(result);
    }

    @Override
    public Signs getRandomSigns() {
        int randomNum = random.nextInt(3);
        return switch (randomNum){
            case 0 -> Signs.ROCK;
            case 1 -> Signs.PAPER;
            default -> Signs.SCISSORS;
        };
    }

    @Override
    public Result getTheResult(Signs playerASign, Signs playerBSign) {
        if(playerASign == playerBSign)
            return Result.DRAW;
        if(playerASign == Signs.PAPER  && playerBSign == Signs.ROCK ||
                playerASign == Signs.ROCK  && playerBSign == Signs.SCISSORS ||
                playerASign == Signs.SCISSORS  && playerBSign == Signs.PAPER)
            return Result.WIN;
        else
            return Result.LOSE;
    }

    @Override
    public void changePlayersScore(Result result) {
        if(result == Result.WIN)
            playersScore.increasePlayerAScore();
        if(result == Result.LOSE)
            playersScore.increasePlayerBScore();
        if(result == Result.DRAW)
            playersScore.increaseDrawScore();

    }

    @Override
    public void printTheResult() {
        System.out.printf("Player A wins %d of 100 games%n", playersScore.getPlayerAScore());
        System.out.printf("Player B wins %d of 100 games%n", playersScore.getPlayerBScore());
        System.out.printf("Draws: %d of 100 games", playersScore.getDrawScore());

    }

}
