package com.johnburbridge.tasks;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class WaitingTaskTest {

	@Test
	public void defaultTest() {
		WaitingTask task = new WaitingTask();
		task.run();
		assertEquals(1,task.getWaitAmount());
	}
	
	@Test
	public void shortTest() {
		test(1);
	}
	
	@Test
	public void mediumTest() {
		test(3);
	}
	
	@Test
	public void longTest() {
		test(5);
	}
	
	@Test
	public void interruptTest() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new WaitingTask(10));
		try {
			executor.shutdownNow();
			assertTrue(executor.isShutdown());
		} catch (Exception e) {
			e.printStackTrace();
			fail("The runnable should have shut down cleanly but threw something up!");
		}
	}
	
	protected void test(long waitAmount) {
		WaitingTask task = new WaitingTask(waitAmount);
		task.run();
		assertEquals(waitAmount,task.getWaitAmount());
	}

}
