package com.dataart.proba;

public class SomeThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {			
			try {
				synchronized (this) {
					wait();
					System.out.println("SomeThread2");										
					notify();					
				}	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
