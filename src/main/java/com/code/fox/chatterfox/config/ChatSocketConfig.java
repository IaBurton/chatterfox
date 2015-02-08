package com.code.fox.chatterfox.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class ChatSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config)
	{
		config.enableSimpleBroker("/base");
		config.setApplicationDestinationPrefixes("/anon");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry arg0) 
	{
		arg0.addEndpoint("/conn").withSockJS();
	}

}
