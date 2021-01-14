package com.learn.example.runnable;

public class ThreadSleepRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("子线程输出了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
