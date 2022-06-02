package com.ua.game.demo.service;

import com.ua.game.demo.service.GameRulesService;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameRulesServiceTest {
    private GameRulesService service = new GameRulesService();

    @Test
    public void isPlayerWin_False() {
        // When
        boolean actual = service.isPlayerWin("rock", "paper");
        // Then
        assertFalse(actual);
    }

    @Test
    public void isPlayerWin_True() {
        // When
        boolean actual = service.isPlayerWin("rock", "scissors");
        // Then
        assertTrue(actual);
    }

}