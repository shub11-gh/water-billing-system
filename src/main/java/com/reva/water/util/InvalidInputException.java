package com.reva.water.util;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception{
	String msg=null;
	public InvalidInputException(String msg)
	{
		this.msg=msg;
		
	}
	@Override
	public String toString() {
		return msg;
	}
	
}
