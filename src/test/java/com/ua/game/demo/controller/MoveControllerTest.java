package com.ua.game.demo.controller;

import com.ua.game.demo.service.GameEngineService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.io.IOException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MoveControllerTest {
    @InjectMocks
    private MoveController moveController;
    @Mock
    private GameEngineService gameEngineService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getMove() throws Exception {
       this.mockMvc.perform(get("/")).andExpect(status().isOk());

    }

    @Test
    public void postMove() {
    }

    @Test
    public void testGetMove() {
    }

    @Test
    public void testPostMove() {
    }

    public static class CurbControllerTest {
        private CurbController controller = new CurbController();
        private String url = "url";

        private MockMvc mockMvc;
//
//        @Test
//        public void httpRequestMatch() throws Exception {
//            mockMvc.perform(post()
//                            .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk());
//        }

        @Test
        public void getResponse() throws IOException {
            String actual = controller.getResponse();
        }

        @Test
        public void getBody() {

        }
    }
}