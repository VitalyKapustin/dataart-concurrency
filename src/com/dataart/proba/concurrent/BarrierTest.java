package com.dataart.proba.concurrent;

import java.util.concurrent.CyclicBarrier;

public class BarrierTest {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);

		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new WorkerThread(barrier, i));
			t.start();
		}
	}
}
