package org.example.pps.service;

import org.example.pps.enums.Result;
import org.example.pps.enums.Signs;

public interface GameService {
    public void play();
    public Signs getRandomSigns();
    public Result getTheResult(Signs playerASign, Signs playerBSign);
    public void changePlayersScore(Result result);
    public void printTheResult();


}
