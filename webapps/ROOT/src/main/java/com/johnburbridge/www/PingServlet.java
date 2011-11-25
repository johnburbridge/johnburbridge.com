package com.johnburbridge.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Used for monitoring of the web app's availability - it just prints "alive"
 * 
 * @author jburbridge
 * @since 11/22/2011
 */
public class PingServlet extends HttpServlet {

	private static final long serialVersionUID = -2309037653849090772L;
	private static final String ALIVE = "ALIVE";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().println(ALIVE);
	}

}
