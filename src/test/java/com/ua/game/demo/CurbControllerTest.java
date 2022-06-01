package com.ua.game.demo;

import com.ua.game.demo.controller.CurbController;
import org.junit.Test;

import java.io.IOException;

public class CurbControllerTest {
    private CurbController controller = new CurbController();

    @Test
    public void getResponse() throws IOException {
        controller.getResponse();
    }

    @Test
    public void getBody(){

    }
}