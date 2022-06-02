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
    @Autowired
    private RandomThrowService randomThrowService;

    public String findWinner(String userChoice) {
        log.info("User's choice: {}", userChoice);
        String systemMove;
        try {
            systemMove = controller.getResponse();
        } catch (IOException e) {
            log.info("An error occured during request to Curb Server, generating a random move.");
            systemMove = randomThrowService.calculateRandomThrow();
        }
        if (userChoice.equalsIgnoreCase(systemMove)) {
            return IT_S_A_DRAW;
        } else {
            String result= service.isPlayerWin(userChoice, systemMove) ? YOU_WIN : YOU_LOSE;
            log.info("Game result: {}", result);
            return result;
        }
    }
}
