package com.dataart.task3.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

	private CountDownLatch allParticipantsArrival;
	
	public VideoConference(CountDownLatch allParticipantsArrival) {
		this.allParticipantsArrival = allParticipantsArrival;
	}
	
	@Override
	public void run() {
		try {
			allParticipantsArrival.await();
			System.out.println("All participants have arrived. Let's start the video conference");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
