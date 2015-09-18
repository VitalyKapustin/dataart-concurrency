package com.dataart.task2.locks;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Job implements Runnable {
	
	private Lock lock;
	private String documentName;	
	
	public Job(Lock lock, String documentName) {
		this.lock = lock;
		this.documentName = documentName;				
	}

	@Override
	public void run() {
		lock.lock();
		workProcess();
		lock.unlock();
	}
	
	private void workProcess() {
		try {
			int workTime = new Random().nextInt(5) + 1;
			System.out.println("Printer 1: PrintQueue: Printing a document \"" + documentName + "\" during " + workTime + " seconds");
			TimeUnit.SECONDS.sleep(workTime);
			System.out.println("Printer 1: The document \"" + documentName + "\" has been printed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
