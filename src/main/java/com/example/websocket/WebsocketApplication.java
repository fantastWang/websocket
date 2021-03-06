package com.example.websocket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("WebSocket项目启动完成");
    }
}
