package exception;

import java.util.concurrent.*;

public class ThreadDemoAllnOne {

    // 1️⃣ Extending Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread running: " + Thread.currentThread().getName());
            try {
            	// CPU is released so other threads can execute.
            	// lock is still there , throws interrupt exception if called before sleep time
            	// sleep belongs to 
            	for(int i=0;i<10;i++) {
            		System.out.println("MyThread running: " + Thread.currentThread().getName());
            		MyThread.yield();
            	}
                Thread.sleep(1000); // sleep()
                
            } catch (InterruptedException e) {
                System.out.println("MyThread interrupted");
            }
        }
    }

    // 2️⃣ Implementing Runnable
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable running: " + Thread.currentThread().getName());
        }
    }

    // 3️⃣ Implementing Callable
    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("MyCallable running: " + Thread.currentThread().getName());
            Thread.sleep(500);
            return 100;
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Main thread: " + Thread.currentThread().getName());

        // ---------- Thread example ----------
        MyThread t1 = new MyThread();
        MyThread t11 = new MyThread();
        t1.setName("Thread-Extendst1");
        t11.setName("Thread-Extendst11");
        //t1.setPriority(Thread.MAX_PRIORITY);
        t1.start(); // start()
        t11.start();
        t1.interrupt();

        // ---------- Runnable example ----------
        Thread t2 = new Thread(new MyRunnable(), "Thread-Runnable");
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.start();

        // ---------- Callable example ----------
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new MyCallable());

        // isAlive()
        System.out.println("t1 is alive? " + t1.isAlive());

        // join()
        t1.join();// teels main to wait until it finished
        t2.join();
        System.out.println(t1.getState());
        System.out.println(t2.getState());

        // get result from Callable
        Integer result = future.get(); // blocks until result available
        System.out.println("Callable result: " + result);

        executor.shutdown();

        // interrupt()
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted during sleep");
            }
        }, "Interrupt-Thread");

        t3.start();
        Thread.sleep(1000);
        t3.interrupt(); // interrupt()

        System.out.println("Main thread finished");
    }
}

