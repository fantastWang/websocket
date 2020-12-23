package com.example.websocket.config;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/webSocket/{userId}")
@Component
public class WebSocketEndpoint {

    //websocket会话，用于接收发送消息
    private Session session;

    //连接建立时
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        //将会话添加到连接池中
        SessionPool.sessionMap.put(userId, session);
    }

    //连接关闭时
    @OnClose
    public void onClose(Session session) throws IOException {
        SessionPool.close(session.getId());
        session.close();
    }

    //发送消息
    @OnMessage
    public void onMessage(Session session, String msg) {
        SessionPool.sendMessage(msg);
    }
}
