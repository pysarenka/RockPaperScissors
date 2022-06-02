package com.ua.game.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RandomThrowService {

    public String calculateRandomThrow() {
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
