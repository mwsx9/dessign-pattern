package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier {

    public static void main(String[] args) {
        //CyclicBarrier barrier = new CyclicBarrier(20);
        CyclicBarrier barrier = new CyclicBarrier(10, () -> {
            System.out.println("满人");
        });

        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() { System.out.println("满人，发车");
        } });*/

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "_" + barrier.getNumberWaiting());
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
