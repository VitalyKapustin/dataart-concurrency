package com.dataart.task1.threads;

import java.util.concurrent.TimeUnit;

/**
 * Walls of house
 * @author vkapustin
 */
public class WallsThread extends BuildingThread implements Runnable {

	public WallsThread(int number, Thread parentThread) {
		super(number, parentThread);
	}

	@Override
	public void run() {
		System.out.println("Thread " + number + " walls");
		try {
			TimeUnit.SECONDS.sleep(time);
			wait4ParentThread();			
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		System.out.println("Thread " + number + " walls has been built");
	}
}
