/**
 * 
 */
package com.johnburbridge.www;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author jburbridge
 *
 */
public class HelloTest {

	/**
	 * Test method for {@link com.johnburbridge.www.Hello#getHelloMessage()}.
	 */
	@Test
	public void testGetHelloMessage() {
		Hello hello = new Hello();
		assertEquals(hello.getHelloMessage(),"Hello there!");
	}
}
