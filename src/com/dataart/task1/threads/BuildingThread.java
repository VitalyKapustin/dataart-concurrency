package com.dataart.task1.threads;

import java.util.Random;

/**
 * Base logic for building every part of 3 ones of a house: foundation, walls, roof  
 * @author vkapustin
 */
public abstract class BuildingThread {

	/** building time */
	protected long time;
	
	/** thread number */
	protected int number;
	
	/** parent thread for waiting for */
	protected Thread parentThread;
	
	protected BuildingThread(int number, Thread parentThread) {
		this.time = new Random().nextInt(10) + 1;
		this.number = number;
		this.parentThread = parentThread;
	}
	
	protected void wait4ParentThread() {
		if (parentThread != null) {
			try {
				parentThread.join();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}			
		}
	}
}
