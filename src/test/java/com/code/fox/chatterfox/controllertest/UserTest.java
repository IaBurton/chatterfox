package com.code.fox.chatterfox.controllertest;


import static org.junit.Assert.*;

import com.code.fox.chatterfox.data.AnonUser;

import org.junit.*;

public class UserTest {
	
	public AnonUser testUser;
	
	@Before
	public void init(){
		testUser = new AnonUser();
		testUser.setName("Billy Bob Jackson");
	}
	
	@Test
	public void testUser() throws Exception{
		assertEquals(testUser.getName(),"Billy Bob Jackson");
	}
	
}
