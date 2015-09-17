package com.dataart.task2.atomic;

import com.dataart.task2.atomic.counters.Counter;

public class IncrementerThread implements Runnable {	
	
	private Counter counter;
	private int iterationsNumber;
	
	public IncrementerThread(Counter counter, int iterationsNumber) {
		this.counter = counter;
		this.iterationsNumber = iterationsNumber;
	}

	@Override
	public void run() {
		for (int i = 0; i < iterationsNumber; i++) {			
			counter.increment();			
		}
	}
}
