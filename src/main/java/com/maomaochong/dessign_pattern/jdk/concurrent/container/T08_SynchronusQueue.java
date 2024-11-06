package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            String str = null;
            try {
                str = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str);
        }, "thread_1").start();


        try {
            blockingQueue.put("adb");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
