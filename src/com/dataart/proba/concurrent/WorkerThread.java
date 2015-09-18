package com.dataart.proba.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class WorkerThread implements Runnable {

	private CyclicBarrier barrier = null;
	private int name = 0;

	public WorkerThread(CyclicBarrier barrier, int name) {
		this.barrier = barrier;
		this.name = name;
	}

	public void run() {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String s = fmt.format(new Date());
		System.out.println(s + "=Doing some work for thread: " + this.name);
		try {
			TimeUnit.SECONDS.sleep(name);			
			s = fmt.format(new Date());
			System.out.println(s + "=Work done for thread: " + this.name);
			int count = barrier.await();
			s = fmt.format(new Date());
			System.out.println(s + "=Inside thread " + this.name + " count is " + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}