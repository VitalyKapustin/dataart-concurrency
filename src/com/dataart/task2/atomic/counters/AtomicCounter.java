package com.dataart.task2.atomic.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

	private AtomicInteger counter = new AtomicInteger();
	
	@Override
	public void increment() {
		counter.incrementAndGet();
	}

	@Override
	public int getValue() {
		return counter.get();
	}
}
