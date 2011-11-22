/**
 * 
 */
package com.johnburbridge.www;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author jburbridge
 *
 */
public class PingCheckTest {

	@Test
	public void test() throws IOException {
		PingCheck pingCheck = new PingCheck();
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		Mockito.when(response.getWriter()).thenReturn(new PrintWriter(System.out));
		try {
			pingCheck.doGet(request, response);
		} catch (ServletException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
