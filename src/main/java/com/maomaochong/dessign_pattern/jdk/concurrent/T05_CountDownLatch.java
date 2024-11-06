package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class T05_CountDownLatch {
    volatile private List<Object> list = new ArrayList<>(10);

    public static void main(String[] args) {
        T05_CountDownLatch t05_countDownLatch = new T05_CountDownLatch();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            latch.countDown();
            System.out.println("t2 end");
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("add value = " + i);
                t05_countDownLatch.add(i);
                if (t05_countDownLatch.size() == 5) {
                    countDownLatch.countDown();
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }

    public void add(Object value) {
        if (value == null) {
            return;
        }

        list.add(value);
    }

    public int size() {
        return list.size();
    }
}
