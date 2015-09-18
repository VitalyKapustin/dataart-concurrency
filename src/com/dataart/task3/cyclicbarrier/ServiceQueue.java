package com.dataart.task3.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class ServiceQueue {

	private final int DEFAULT_QUEUE_SIZE = 5;	
	
	private CyclicBarrier cyclicBarrier;
	
	public ServiceQueue() {
		cyclicBarrier = new CyclicBarrier(DEFAULT_QUEUE_SIZE);
	}
	
	public ServiceQueue(int queueSize) {
		cyclicBarrier = new CyclicBarrier(queueSize);
	}
}
