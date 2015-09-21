package com.dataart.task2.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.dataart.task2.atomic.counters.AtomicCounter;
import com.dataart.task2.atomic.counters.Count;
import com.dataart.task2.atomic.counters.Counter;
import com.dataart.task2.atomic.counters.SynchronizedCounter;
import com.dataart.task2.atomic.counters.SynchronizedThisCounter;
import com.dataart.task2.atomic.counters.VolatileCounter;
import com.dataart.task2.atomic.utils.StopWatch;

public class Main {
	
	private final static int THREADS_NUMBER = 2;
	private final static int ITERATIONS_NUMBER = 50000;	

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Test increment with simple Counter object
		 */		
		testCounter(new Count(), "Test increment with simple Counter");
		
		/**
		 * Test increment with AtomicCounter
		 */
		testCounter(new AtomicCounter(), "Test increment with AtomicCounter");
		
		/**
		 * Test increment with VolatileCounter
		 */
		testCounter(new VolatileCounter(), "Test increment with VolatileCounter");
		
		/**
		 * Test increment with SynchronizedCounter
		 */
		testCounter(new SynchronizedCounter(), "Test increment with SynchronizedCounter");
		
		/**
		 * Test increment with SynchronizedThisCounter
		 */
		testCounter(new SynchronizedThisCounter(), "Test increment with SynchronizedThisCounter");
	}
	
	private static void testCounter(Counter counter, String testDescription) throws InterruptedException {
		System.out.println(testDescription);
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);		
		for (int i = 0; i < THREADS_NUMBER; i++) {
			executorService.execute(new IncrementerThread(counter, ITERATIONS_NUMBER));			
		}		
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		System.out.println("Expected result: " + THREADS_NUMBER * ITERATIONS_NUMBER);		
		System.out.println("Actual result: " + counter.getValue());
		
		stopWatch.stop();
		System.out.println("Total execution time: " + stopWatch.getTime());		
		System.out.println();
	}
}
