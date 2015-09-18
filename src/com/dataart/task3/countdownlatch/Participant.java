package com.dataart.task3.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

	private CountDownLatch allParticipantsArrival;
	
	public Participant(CountDownLatch allParticipantsArrival) {
		this.allParticipantsArrival = allParticipantsArrival;
	}

	@Override
	public void run() {
		try {			
			TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
			System.out.println("Participant has arrived");
			allParticipantsArrival.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
