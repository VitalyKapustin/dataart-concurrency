package com.dataart.task3.semaphore;

public class Job implements Runnable {	
	
	private PrintQueue printQueue;
	private String document;
	
	public Job(PrintQueue printQueue, String document) {
		this.printQueue = printQueue;
		this.document = document;
	}
	
	@Override
	public void run() {
		printQueue.printJob(document);
	}
}
