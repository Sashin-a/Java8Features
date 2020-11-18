package com.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StarterClass {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			ExecutorRunnable exR = new ExecutorRunnable("abcd");
			es.execute(exR);

		}
	}

}

class ExecutorRunnable implements Runnable {
	private final String message;

	public ExecutorRunnable(String message) {
		this.message = message;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
		// call workToBeDone method to simulate a delay
		workToBeDone();
		System.out.println(Thread.currentThread().getName() + " (End)");// prints thread name
	}

	private void workToBeDone() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
