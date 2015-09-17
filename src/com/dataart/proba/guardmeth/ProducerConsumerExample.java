package com.dataart.proba.guardmeth;

public class ProducerConsumerExample {
	
	public static void main(String[] args) throws InterruptedException {
		Drop drop = new Drop();
		Thread thread1 = new Thread(new Producer(drop)); 
		thread1.start();
		Thread thread2 = new Thread(new Consumer(drop));
		thread2.start();
		thread1.join();
		System.out.println("sdfsdf");
		thread2.join();
		System.out.println("sdfsdf");
	}
}