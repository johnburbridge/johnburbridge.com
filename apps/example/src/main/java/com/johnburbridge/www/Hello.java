package com.johnburbridge.www;

import static com.johnburbridge.common.Constants.*;

/**
 * A simple hello pojo
 * 
 * @author jburbridge
 * @since 10/17/2011
 */
public class Hello {

	private final String helloMessage = HELLO + " there!";
	
	/**
	 * @return the hello message
	 */
	public String getHelloMessage() {
		return helloMessage;
	}
}

