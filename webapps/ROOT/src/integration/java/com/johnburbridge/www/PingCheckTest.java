package com.johnburbridge.www;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

public class PingCheckTest {

	private static final String CHECK_VALUE = "ALIVE";
	private static final String DEFAULT_HOSTNAME = "localhost";
	private static final String DEFAULT_PORT = "9090";
	private static final String PING_PATH = "/ping";
	private static URL url;
	
	@BeforeClass
	public static void setUp() throws MalformedURLException {
		
		String cargoHost = System.getProperty("cargo.hostname") != null ? 
				System.getProperty("cargo.hostname") : DEFAULT_HOSTNAME;

		String cargoPort = System.getProperty("cargo.port") != null ? 
				System.getProperty("cargo.port") : DEFAULT_PORT;
				
		url = new URL(new StringBuilder("http://").append(cargoHost)
				.append(":").append(cargoPort).append(PING_PATH).toString());
	}
	
	@Test
	public void test() throws IOException {
		
		StringBuilder resultString = new StringBuilder();
		HttpURLConnection connection  = (HttpURLConnection) url.openConnection();
		connection.connect();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			resultString.append(inputLine);
		}
		in.close();
		connection.disconnect();
		
		assertTrue("Expected ALIVE but got a different result from PingCheck", 
				resultString.toString().indexOf(CHECK_VALUE) >= 0);
	}
}
