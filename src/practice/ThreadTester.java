package practice;

public class ThreadTester {

	public static void main(String[] args) {
		System.out.println("main thread is starting");
		
//		Thread thread1= new Thread1("thread1");
//		//thread1.setDaemon(true);
//		thread1.start();
//		
//		//Thread thread2= new Thread(new Thread2(), "Thread2");
//		Thread thread2= new Thread(()->
//		{
//			for(int i=0; i<5; i++)
//				System.out.println("Inside " +Thread.currentThread()+ " " +i);
//		}, "Thread2");
//		thread2.start();
		
//		Stack stack= new Stack(5);
//		
//		new Thread(()->{
//			int counter=0;
//			while(++counter<10)
//				System.out.println("Pushed: "+stack.push(100));
//		}, "Pusher").start();
//		
//		new Thread(()->{
//			int counter=0;
//			while(++counter<10)
//				System.out.println("Popped: "+stack.pop());
//		}, "Popper").start();
		
//		Thread thread3= new Thread(()->{
//			try {
//				Thread.sleep(1);
//				for(int i=10000; i>0; i--);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		},"States");
//		
//		thread3.start();
//		
//		while(true) {
//			Thread.State state= thread3.getState();
//			System.out.println(state);
//			if(state==Thread.State.TERMINATED) break;
//		}
		
//		Thread thread= new Thread(()->{
//			System.out.println(Thread.currentThread());
//		},"Our Thread");
//		
//		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		String lock1= "Akash";
		String lock2= "Jadhav";
		
		Thread thread1= new Thread(()->{
			synchronized (lock1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("Lock Acquired");
				}
			}
		},"thread1");
		
		Thread thread2= new Thread(()->{
			synchronized (lock2) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("Lock Acquired");
				}
			}
		},"thread2");
		
		thread1.start();
		thread2.start();
		
		System.out.println("main thread is exiting");
	
	}

}
