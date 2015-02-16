package com.code.fox.chatterfox.controllertest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.code.fox.chatterfox.controller.BaseController;
import com.code.fox.chatterfox.data.provider.AnonManager;

public class BaseControllerTest {
	
	@Mock
	private AnonManager anonManager;
	
	@InjectMocks
	private BaseController baseController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		//process mocks for this class
		MockitoAnnotations.initMocks(this);
		
		//test BaseController on its own
		mockMvc = MockMvcBuilders.standaloneSetup(baseController).build();
	}
	
	@Test
	public void testControllerPOST() throws Exception
	{
		mockMvc.perform(post("/login/anon/")
				.param("name", "test"))
				.andExpect(status().isOk())
				.andExpect(content().string("success"));
		
		//this succeeds even though it shouldn't (controller should return failure because that user already exists)
		/*mockMvc.perform(post("/login/anon/")
				.param("name", "test"))
				.andExpect(status().isOk())
				.andExpect(content().string("success"));*/
	}
	
	@Test //this succeeds even when POST is commented out
	public void testControllerGET() throws Exception
	{
		mockMvc.perform(get("/chat/test"))
				.andExpect(status().isOk())
				.andExpect(view().name("chat"))
				.andExpect(model().attribute("user", anonManager.getUser("test")));
	}
	
}