package com.dataart.task4.futuretask;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SpaceCraft implements Callable<String> {

	private String name; 
	
	public SpaceCraft(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println(name + " is being prepared");
		TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
		return name + " has been prepared";
	}
}
