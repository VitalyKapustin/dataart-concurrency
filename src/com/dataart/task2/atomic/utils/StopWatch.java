package com.dataart.task2.atomic.utils;

/**
 * StopWatch like in the library Apache Commons
 * @author vkapustin
 */
public class StopWatch {

	private long startTime;
	private long stopTime;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	public long getTime() {
		return stopTime - startTime;
	}
}
