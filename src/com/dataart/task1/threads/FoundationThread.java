package com.dataart.task1.threads;

import java.util.concurrent.TimeUnit;

/**
 * Foundation of house
 * @author vkapustin
 */
public class FoundationThread extends BuildingThread implements Runnable {

	public FoundationThread(int number) {
		super(number, null);
	}
	
	public FoundationThread(int number, Thread parentThread) {
		super(number, parentThread);
	}
	
	@Override
	public void run() {
		System.out.println("Thread " + number + " foundation");
		try {
			TimeUnit.SECONDS.sleep(time);			
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		System.out.println("Thread " + number + " foundation has been built");		
	}
}
