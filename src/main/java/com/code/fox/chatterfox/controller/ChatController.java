package com.code.fox.chatterfox.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.code.fox.chatterfox.data.Message;

@Controller
public class ChatController {
	
	@MessageMapping("/conn")
	@SendTo("/base/chat/anonmess")
	public Message relay(Message message) throws Exception
	{
		//could do other things such as stats or filtering here as well
		return message;
	}
	
}
