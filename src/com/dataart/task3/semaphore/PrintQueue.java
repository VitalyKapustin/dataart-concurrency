package com.dataart.task3.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue {
	
	private final int DEFAULT_QUEUE_SIZE = 5;

	private Semaphore semaphore;	
		
	public PrintQueue() {
		this.semaphore = new Semaphore(DEFAULT_QUEUE_SIZE);
	}
	
	public PrintQueue(int queueSize) {
		this.semaphore = new Semaphore(queueSize);
	}
	
	public void printJob(String document) {
		try {
			semaphore.acquire();
			System.out.println("Printing document: " + document);
			TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
