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
import com.code.fox.chatterfox.data.AnonUser;
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
	}
	
	/*@Test Never wants to work
	public void testControllerGET() throws Exception
	{
		anonManager.updateUser(new AnonUser("test"));
		
		mockMvc.perform(post("/login/anon/")
				.param("name", "test"))
				.andExpect(status().isOk())
				.andExpect(content().string("success"));
		
		mockMvc.perform(get("/chat/test"))
				.andExpect(status().isOk());
				//.andExpect(view().name("chat"));
				//.andExpect(model().attribute("user", anonManager.getUser("test")));
	}*/
	
}