package com.ua.game.demo.controller;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ua.game.demo.exception.CustomException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;

import java.io.IOException;
@Controller
public class CurbController {

    private static final String SERVER_URL = "https://5eddt4q9dk.execute-api.us-east-1.amazonaws.com/rps-stage/throw";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public String getResponse() throws IOException {
        HttpGet request = new HttpGet(SERVER_URL);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new CustomException();
            } else {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
               return jsonObject.get("body").getAsString();
            }
        }
    }

}
