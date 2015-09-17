package com.dataart.task2.atomic.counters;

public class SynchronizedCounter implements Counter {

	private int counter;
	
	@Override
	public synchronized void increment() {
		counter++;		
	}

	@Override
	public synchronized int getValue() {		
		return counter;
	}
}
