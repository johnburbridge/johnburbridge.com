package com.johnburbridge.tasks;

import static org.junit.Assert.*;

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
	
	protected void test(long waitAmount) {
		WaitingTask task = new WaitingTask(waitAmount);
		task.run();
		assertEquals(waitAmount,task.getWaitAmount());
	}

}
