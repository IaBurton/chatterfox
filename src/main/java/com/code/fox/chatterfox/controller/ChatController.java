package com.code.fox.chatterfox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import com.code.fox.chatterfox.data.Message;
import com.code.fox.chatterfox.data.provider.AnonManager;

@Controller
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private AnonManager anonManager;
	
	@MessageMapping("/conn")
	@SendTo("/base/chat/anonmess")
	public Message relay(Message message) throws Exception
	{
		//could do other things such as stats or filtering here as well
		return message;
	}
	
	@MessageMapping("/conn/message/{name}")
	public void relayPrivate(@DestinationVariable String name, Message message) throws Exception
	{
		template.convertAndSend("/private/conn/message/" + name, message);
	}
	
	@Scheduled(fixedDelay = 4000)
	public void usersUpdate() throws Exception
	{
		template.convertAndSend("/base/chat/users", anonManager.toString());//new Message("", anonManager.toString(), ""));
	}
}
