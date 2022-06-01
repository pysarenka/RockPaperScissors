package com.ua.game.demo.controller;


import com.ua.game.demo.service.GameEngineService;
import com.ua.game.demo.model.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MoveController {
    @Autowired
    private GameEngineService gameEngineService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMove() {
        return "start.html";
    }

    @PostMapping(value = "/getWinner", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<String> postMove(Choice playerChoice) {
        String playerMove = playerChoice.getMove();
        return ResponseEntity.ok(gameEngineService.findWinner(playerMove));
    }
}
