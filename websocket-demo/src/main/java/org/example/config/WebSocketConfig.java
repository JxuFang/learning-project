package org.example.config;

import org.example.handler.MyWsHandler;
import org.example.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-02-28 13:41
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Bean
    public TextWebSocketHandler myWsHandler() {
        return new MyWsHandler();
    }

    @Bean
    public HttpSessionHandshakeInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWsHandler(), "myWs").setAllowedOrigins("*")
                .addInterceptors(myInterceptor());
    }
}