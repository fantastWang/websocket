package com.example.websocket.config;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionPool {

    public static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    public static void close(String sessionId) {
        for (String userId : sessionMap.keySet()) {
            Session session = sessionMap.get(userId);
            if (session.getId().equals(sessionId)) {
                sessionMap.remove(userId);
                break;
            }
        }
    }

    public static void sendMessage(String msg) {
        for (String userId : sessionMap.keySet()) {
            sessionMap.get(userId).getAsyncRemote().sendText(msg);
        }
    }

    public static void sendMessage(String msg, String sessionId) {
        sessionMap.get(sessionId).getAsyncRemote().sendText(msg);
    }
}
