package com.multithreading;

public class StartClass {
	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("Running this value:" + 
				Thread.currentThread().isAlive() + " "+
				Thread.currentThread().getName());

		Thread t1 = new Thread(r1);
		t1.start();

		SomeThread st1 = new SomeThread();
		st1.start();
	}

}

class SomeThread extends Thread {
	@Override
	public void run() {
		{
			System.out.println("Running this thread" + Thread.currentThread().getName());
		}
	}
}