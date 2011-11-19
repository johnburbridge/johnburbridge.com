package com.johnburbridge.tasks;

/**
 * A runnable that waits for a given amount of time
 * @author jburbridge
 *
 */
public class WaitingTask implements Runnable {

	/**
	 * How much time should we run for?
	 */
	private final long waitAmount;
	private long startTime;
	private long endTime;
	
	/**
	 * The default is 1 second
	 */
	public WaitingTask() {
		this.waitAmount = 1;
	}

	/**
	 * @param waitAmount
	 */
	public WaitingTask(long waitAmount) {
		this.waitAmount = waitAmount;
	}

	@Override
	public void run() {
		startTime = System.currentTimeMillis();
		endTime = startTime + (waitAmount * 1000);
		System.out.printf("Sleeping for %d seconds\n", waitAmount);
		while (System.currentTimeMillis() <= endTime) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.printf("Quitting before reaching %c\n", endTime);
			}
		}
	}

	public long getWaitAmount() {
		return waitAmount;
	}
}