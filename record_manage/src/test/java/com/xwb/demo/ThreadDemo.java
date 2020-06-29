package com.xwb.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class ThreadDemo {

	private Integer i;
	
//	public static void main(String[] args) throws Exception {
//		ThreadDemo thread = new ThreadDemo();
//		thread.testState();
//	}
	
	public void test1() throws Exception {
		Thread t1 = new Thread(() -> {
			if(i == null) {
				System.out.println("没拿到冰淇淋，等待中。。。");
				System.out.println(this);
				synchronized (this) {					
					Thread.currentThread().suspend();
				}
			}
			System.out.println("拿到冰淇淋。。。");
		});
		
		t1.start();
		
		Thread.sleep(3000L);
		System.out.println("通知小朋友");
		System.out.println(this);
		synchronized (this) {			
			t1.resume();
		}
	}
	
	public void testState() throws Exception {
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(3000L);
				LockSupport.park();
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.out.println("1." + t1.getState());
		
		Thread.sleep(3000L);
		
		t1.start();
		
		Thread.sleep(1000L);
		
		System.out.println("2." + t1.getState());
		
		Thread.sleep(4000L);
		
		System.out.println("3." + t1.getState());
		
		Thread.sleep(3000L);
		
		LockSupport.unpark(t1);
		
		Thread.sleep(1000L);
		
		System.out.println("4." + t1.getState());
		
		Thread.sleep(3000L);
		
		System.out.println("5." + t1.getState());
	}
	
	public void testInterrupt() throws InterruptedException {
		i = 1;
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (i) {
					try {
						System.out.println("等待。。。");
						i.wait();
						System.out.println("等待结束");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		t.start();
		
		Thread.sleep(1000L);
		
		synchronized (i) {			
			System.out.println("通知。。。");
			i.notify();
		}
	}
	
	void testPark() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			while(true) {
				LockSupport.park();
				
				System.out.println("子线程输出。。。");
			}
		});
		
		t1.start();
		Thread.sleep(1000);
		t1.interrupt();
		System.out.println("main thread end...");
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo thread = new ThreadDemo();
		thread.testPark();
	}
}
