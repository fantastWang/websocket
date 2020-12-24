package com.example.websocket.config;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author wangchaojie
 * @Description 会话池
 * @Date 8:53 2020/12/24
 **/
public class SessionPool {
    //用于存储会话
    public static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    //用于释放会话池中的对象
    public static void close(String sessionId) {
        for (String userId : sessionMap.keySet()) {
            Session session = sessionMap.get(userId);
            if (session.getId().equals(sessionId)) {
                sessionMap.remove(userId);
                break;
            }
        }
    }

    //群发：没有发向对应的sessionId
    public static void sendMessage(String msg) {
        for (String userId : sessionMap.keySet()) {
            sessionMap.get(userId).getAsyncRemote().sendText(msg);
        }
    }

    //群发：没有发向对应的sessionId
    public static void sendMessage(String msg, String sessionId) {
        sessionMap.get(sessionId).getAsyncRemote().sendText(msg);
    }
}
