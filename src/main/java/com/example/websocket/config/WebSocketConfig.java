package com.example.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/***
 * 注入ServerEndpointExporter，该bean会自动注册使用@ServerEndpoint注解后的类
 **/
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter getServerEndpoint() {
        return new ServerEndpointExporter();
    }
}
