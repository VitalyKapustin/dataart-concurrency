package com.dataart.task4.scheduledfuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.dataart.task2.atomic.utils.StopWatch;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		stopWatch.start();
		scheduledExecutorService.schedule(new Task(), 5, TimeUnit.SECONDS);
		scheduledExecutorService.shutdown();
		scheduledExecutorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		stopWatch.stop();
		System.out.println("Delay time: " + stopWatch.getTime());
	}
}
