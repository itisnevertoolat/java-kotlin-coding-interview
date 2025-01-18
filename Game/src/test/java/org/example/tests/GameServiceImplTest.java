package org.example.tests;

import org.example.pps.service.GameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.mockito.Mockito.*;

public class GameServiceImplTest {

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private Random random;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test_PlayerAWins() {
        when(random.nextInt(3)).thenReturn(1);
        gameService.play();
        Assertions.assertEquals(1, gameService.playersScore.getPlayerAScore());
        Assertions.assertEquals(0, gameService.playersScore.getPlayerBScore());
        Assertions.assertEquals(0, gameService.playersScore.getDrawScore());
    }

    @Test
    void test_PlayerBWins() {
        when(random.nextInt(3)).thenReturn(2);
        gameService.play();
        Assertions.assertEquals(0, gameService.playersScore.getPlayerAScore());
        Assertions.assertEquals(1, gameService.playersScore.getPlayerBScore());
        Assertions.assertEquals(0, gameService.playersScore.getDrawScore());
    }

    @Test
    void test_Draw() {
        when(random.nextInt(3)).thenReturn(0);
        gameService.play();
        Assertions.assertEquals(0, gameService.playersScore.getPlayerAScore());
        Assertions.assertEquals(0, gameService.playersScore.getPlayerBScore());
        Assertions.assertEquals(1, gameService.playersScore.getDrawScore());
    }

}