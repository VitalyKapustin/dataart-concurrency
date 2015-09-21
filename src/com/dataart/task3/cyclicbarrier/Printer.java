package com.dataart.task3.cyclicbarrier;

public class Printer {

	private ServiceQueue serviceQueue;
	
	public Printer(ServiceQueue serviceQueue) {
		this.serviceQueue = serviceQueue;
	}
	
	public void print(String document) {		
		serviceQueue.add();			
		System.out.println("Printing: \"" + document + "\"");			
		serviceQueue.remove();				
	}
}