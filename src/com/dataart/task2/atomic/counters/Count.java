package com.dataart.task2.atomic.counters;

public class Count implements Counter {

	private int counter;
	
	@Override
	public void increment() {
		counter++;		
	}

	@Override
	public int getValue() {
		return counter;
	}	 
}
