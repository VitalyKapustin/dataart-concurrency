package com.dataart.task1.threads;

import java.util.concurrent.TimeUnit;

/**
 * Roof of house
 * @author vkapustin
 */
public class RoofThread extends BuildingThread implements Runnable {

	public RoofThread(int number, Thread parentThread) {
		super(number, parentThread);
	}

	@Override
	public void run() {
		System.out.println("Thread " + number + " roof");
		try {
			TimeUnit.SECONDS.sleep(time);
			wait4ParentThread();
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		System.out.println("Thread " + number + " roof has been built");
	}
}
