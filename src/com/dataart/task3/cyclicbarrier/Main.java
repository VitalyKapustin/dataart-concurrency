package com.dataart.task3.cyclicbarrier;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	private static final int QUEUE_SIZE = 5;	
	
	public static void main(String[] args) throws InterruptedException {
		ServiceQueue serviceQueue = new ServiceQueue(QUEUE_SIZE);
		Printer printer = new Printer(serviceQueue);
		
		ExecutorService executorService = Executors.newFixedThreadPool(QUEUE_SIZE);
		for (int i = 0; i < 10; i++) {			 
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {					
					for (int i = 0; i < 10; i++) {
						printer.print(Thread.currentThread().getName() + " - Document-" + UUID.randomUUID());						
					}					
				}
			});			
		}
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	}
}
