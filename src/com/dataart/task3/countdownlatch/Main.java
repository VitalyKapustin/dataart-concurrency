package com.dataart.task3.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	private static final int PARTICIPANTS_COUNT = 5;
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch allParticipantsArrival = new CountDownLatch(PARTICIPANTS_COUNT);
		new Thread(new VideoConference(allParticipantsArrival)).start();
		ExecutorService executorService = Executors.newFixedThreadPool(PARTICIPANTS_COUNT);
		for (int i = 0; i < PARTICIPANTS_COUNT; i++) {
			executorService.submit(new Participant(allParticipantsArrival));
		}
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	}
}
