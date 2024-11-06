package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                blockingQueue.put("put_" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean b = blockingQueue.offer("a");
        try {
            blockingQueue.add("a");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            blockingQueue.put("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(blockingQueue);
    }
}
