package com.dataart.task4.futuretask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTaskLauncher {

	private final static int SPACE_CRAFTS_COUNT = 5;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(SPACE_CRAFTS_COUNT);
		List<Future<String>> futures = new ArrayList<>(SPACE_CRAFTS_COUNT);
		for (int i = 0; i < SPACE_CRAFTS_COUNT; i++) {
			Callable<String> worker = new SpaceCraft("Spacecraft" + (i + 1));
			Future<String> submit = executorService.submit(worker);
			futures.add(submit);
		}
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		System.out.println("All spacecrafts are ready to run.");
	}
}
