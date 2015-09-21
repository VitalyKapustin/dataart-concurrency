package com.dataart.task3.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ServiceQueue {			
	
	private CyclicBarrier fullCyclicBarrier;
	private CyclicBarrier emptyCyclicBarrier;	
	
	public ServiceQueue(int queueSize) {
		fullCyclicBarrier = new CyclicBarrier(queueSize, new FullQueueAction());
		emptyCyclicBarrier = new CyclicBarrier(queueSize, new EmptyQueueAction());
	}
	
	public void add() {
		try {			
			fullCyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}	
	
	public void remove() {
		try {
			emptyCyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	private class FullQueueAction implements Runnable {

		@Override
		public void run() {			
			System.out.println("Queue is full");			
		}		
	}
	
	private class EmptyQueueAction implements Runnable {

		@Override
		public void run() {
			System.out.println("Queue is empty");
		}	
	}
}
