package com.code.fox.chatterfox.data;

//basic anonymous user
public class AnonUser extends User {
	
	//blank constructor if we want to set name later
	public AnonUser() {}
	
	public AnonUser(String name)
	{
		super.name = name;
	}

	@Override
	public String getName() {
		return super.name;
	}

	@Override
	public void setName(String name) {
		super.name = name;
	}

}
