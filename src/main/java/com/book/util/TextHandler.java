package com.book.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Myth on 2017/2/7 0007
 * 注册一个websocket的具体服务器，但是真正的实现是另一个类
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class TextHandler extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //registry.addHandler(systemWebSocketHandler(),"/message");
        registry.addHandler(systemWebSocketHandler(),"/message/sockjs").setAllowedOrigins("*").withSockJS();

    }

    @Bean
    public WebSocketHandler systemWebSocketHandler() {
        return new SystemWebSocketHandler();
    }
}
