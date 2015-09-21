package com.dataart.task3.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	private final static int DOCUMENT_COUNT = 50;	
	
	public static void main(String[] args) throws InterruptedException {
		PrintQueue printQueue = new PrintQueue();		
		ExecutorService executorService = Executors.newFixedThreadPool(DOCUMENT_COUNT);
		for (int i = 0; i < DOCUMENT_COUNT; i++) {
			executorService.execute(new Job(printQueue, "Document" + (i + 1)));
		}
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	}
}
