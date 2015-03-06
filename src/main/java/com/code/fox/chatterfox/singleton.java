//singleton sample class for assignment 9

package com.code.fox.chatterfox;

public class singleton {
    private static singleton instance = null;
    
    protected singleton(){
    	
    }
    
    public static singleton getInstance(){
    	if(instance == null) {
    		instance = new singleton();
    	}
    	return instance;
    }
    
}
