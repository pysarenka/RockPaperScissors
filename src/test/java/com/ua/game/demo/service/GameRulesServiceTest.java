package com.ua.game.demo.service;

import com.ua.game.demo.service.GameRulesService;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameRulesServiceTest {
    private GameRulesService service = new GameRulesService();

    @Test
    public void isPlayerWin_False() {
        boolean actual=service.isPlayerWin("rock", "paper");
        assertFalse(actual);
    }
    @Test
    public void isPlayerWin_True() {
        boolean actual=service.isPlayerWin("rock", "scissors");
        assertTrue(actual);
    }

}