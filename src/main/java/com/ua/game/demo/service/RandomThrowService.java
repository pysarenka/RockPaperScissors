package com.ua.game.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
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
        log.info("Generating a random move: {}", move);
        return move;
    }
}
