package com.dataart.proba;

public class SomeThread implements Runnable {

	@Override
	public void run() {		
		for (int i = 0; i < 500; i++) {
			try {
				synchronized (this) {					
					System.out.println("SomeThread");					
					wait();
				}								
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}				
	}
}