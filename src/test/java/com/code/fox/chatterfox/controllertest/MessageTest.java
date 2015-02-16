package com.code.fox.chatterfox.controllertest;

import org.junit.Test;
import static org.junit.Assert.*;

import com.code.fox.chatterfox.data.Message;

public class MessageTest 
{
	@Test
	public void testMessage()
	{
		Message msg = new Message();
		
		String result = msg.getMessage();
		
		assertEquals(null, result);
	}
}
