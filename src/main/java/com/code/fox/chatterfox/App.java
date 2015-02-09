package com.code.fox.chatterfox;

import org.joda.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.code.fox.chatterfox.data.provider.AnonManager;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

	//manager that only retains AnonUsers while server is up, data isn't persistent
	//as it should be for AnonUsers
	@Bean
	public AnonManager anonManager()
	{
		return new AnonManager();
	}
	
	public static void main(String[] args) 
	{
		//Joda-Time imported through Maven. useful classes for easy time-stamps.
		//Imported by Javier Sanchez
		LocalTime localTime = new LocalTime();
		System.out.println("Current Time is: " + localTime.toString());
		
		SpringApplication.run(App.class, args);
	}

}
