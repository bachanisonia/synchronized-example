package com.learnjava.corejava;

public class SynchronizedExample {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		new Thread(counter, "one").start();
		new Thread(counter, "two").start();
		new Thread(counter, "three").start();
		new Thread(counter, "four").start();
		
		Counter counter2 = new Counter();
		new Thread(counter2, "Counter 2 Thread").start();
	}

}



class Counter implements Runnable {

	private int value = 0;
	private Integer i = 10;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void increment() {
		value++;
	}
	
	public void decrement() {
		value--;
	}
	
	
	
	@Override
	public void run() {
	
		synchronized  (this) {
			this.increment();
			System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue() );
			this.decrement();
			System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
		}
		
	}
	
	
}