package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.manager.WsSessionManager;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-01 10:29
 */
@Slf4j
public class MyWsHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("build ws connection");
        WsSessionManager.add(session.getId(), session);
    }

    @Override

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("send test message");
        String payload = message.getPayload();
        log.info("server receive message: " + payload);
        session.sendMessage(new TextMessage("server 发送给的消息 " + payload + "，发送时间:" + LocalDateTime.now().toString()));
    }
}