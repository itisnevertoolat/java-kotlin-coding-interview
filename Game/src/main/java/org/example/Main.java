package org.example;

import org.example.pps.service.GameServiceImpl;

public class Main {
    public static void main(String[] args) {
        GameServiceImpl gameService = new GameServiceImpl();
        int numOfTries = 100;
        for(int i=1;i<=numOfTries;i++){
            gameService.play();
        }
        gameService. printTheResult();


    }
}