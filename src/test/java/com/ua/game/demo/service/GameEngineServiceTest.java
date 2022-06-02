package com.ua.game.demo.service;

import com.ua.game.demo.controller.CurbController;
import com.ua.game.demo.exception.CustomException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineServiceTest {
    @InjectMocks
    private GameEngineService gameEngineService;
    @Mock
    private CurbController controller;
    @Mock
    private GameRulesService service;
    @Mock
    private RandomThrowService randomThrowService;


    @Test
    public void isDraw() throws IOException {
        when(controller.getResponse()).thenReturn("rock");
        String actual = gameEngineService.findWinner("rock");
        assertEquals("It's a draw!", actual);
    }


    @Test
    public void isExceptionThrown() throws IOException {
        when(controller.getResponse()).thenThrow(new CustomException());
        when(randomThrowService.calculateRandomThrow()).thenReturn("rock");
        String actual = gameEngineService.findWinner("scissors");
        assertEquals("You lose!",actual);
    }


}