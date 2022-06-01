package com.ua.game.demo.service;


import com.ua.game.demo.controller.CurbController;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Slf4j
@Service
public class GameEngineService {
    private static final String YOU_LOSE = "You lose!";
    private static final String IT_S_A_DRAW = "It's a draw!";
    private static final String YOU_WIN = "You win!";

    @Autowired
    private GameRulesService service;
    @Autowired
    private CurbController controller;

    public String findWinner(String userChoice) {
        log.info("User's choice: {}", userChoice);
        String systemMove;
        try {
            systemMove = controller.getResponse();
        } catch (IOException e) {
            systemMove = calculateRandomThrow();
        }
        if (userChoice.equalsIgnoreCase(systemMove)) {
            return IT_S_A_DRAW;
        } else {
            return service.isPlayerWin(userChoice, systemMove) ? YOU_WIN : YOU_LOSE;
        }
    }

    private String calculateRandomThrow() {
        int rand = (int) (Math.random() * 3);

        String move = "";
        if (rand == 0) {
            move = "rock";
        } else if (rand == 1) {
            move = "paper";
        } else {
            move = "scissors";
        }
        return move;
    }
}
