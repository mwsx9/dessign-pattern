package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.concurrent.Semaphore;

public class T11_TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10, true);

        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "==" + semaphore.getQueueLength());
                    semaphore.acquire();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("release_" + Thread.currentThread().getName() + "==" + semaphore.getQueueLength());
                }
            }).start();
        }
    }
}
