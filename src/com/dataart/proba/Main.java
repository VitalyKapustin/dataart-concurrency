package com.dataart.proba;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		Thread someThread = threadFactory.newThread(new SomeThread());
		Thread someThread2 = threadFactory.newThread(new SomeThread2());
				
		someThread.start();		
		someThread2.start();	
	}
}
