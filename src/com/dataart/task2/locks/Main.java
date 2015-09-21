package com.dataart.task2.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	private final static int THREADS_COUNT = 5; 
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
		Lock lock = new ReentrantLock();
		for (int i = 0; i < THREADS_COUNT; i++) {
			executorService.execute(new Job(lock, "Document" + (i + 1)));
		}
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	}
}
