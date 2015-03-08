package com.code.fox.chatterfox.data;

import java.util.Date;
/**
 * Abstract user object.
 */
//similar to demo-web-project but abstract with fewer fields
public abstract class User {

	/** Generic name field */
    protected String name;
    /** The timestamp when the user is being created */
    private String creationTime = new Date(System.currentTimeMillis()).toString();

	public abstract String getName();

	public abstract void setName(String name);

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}