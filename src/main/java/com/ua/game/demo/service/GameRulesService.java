package com.ua.game.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameRulesService {

    public boolean isPlayerWin(String userChoice, String systemChoice) {
        Map<String, String> game = new HashMap<>();
        game.put("scissors", "paper");
        game.put("paper", "rock");
        game.put("rock", "scissors");
        String res = game.get(userChoice);
        return res.equals(systemChoice);
    }
}
