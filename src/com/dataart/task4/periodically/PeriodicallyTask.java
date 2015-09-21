package com.dataart.task4.periodically;

import java.util.Date;

public class PeriodicallyTask implements Runnable {	
	
	@Override
	public void run() {
		System.out.println("PeriodicallyTask execution time: " + new Date());
	}
}
