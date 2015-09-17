package com.dataart.task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.dataart.task1.threads.FoundationThread;
import com.dataart.task1.threads.RoofThread;
import com.dataart.task1.threads.WallsThread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		/** used default thread factory */
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		
		/** create threads */
		Thread thread1 = threadFactory.newThread(new FoundationThread(1));
		Thread thread2 = threadFactory.newThread(new WallsThread(2, thread1));
		Thread thread3 = threadFactory.newThread(new RoofThread(3, thread2));		
		
		/** start threads */
		thread3.start();		
		thread2.start();		
		thread1.start();		

		/** wait for all thread to be finished */
		thread1.join();
		thread2.join();
		thread3.join();
		
		System.out.println("The house has been built.");
	}	
}
