package com.dataart.task2.atomic.counters;

public class SynchronizedThisCounter implements Counter {

	private int counter;
	
	@Override
	public void increment() {
		synchronized (this) {
			counter++;			
		}
	}

	@Override
	public int getValue() {
		synchronized (this) {
			return counter;			
		}		
	}
}
