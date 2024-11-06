package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 100; i++) {
            queue.offer("queue" + i);
        }

        System.out.println(queue);

        System.out.println(queue.size());

        System.out.println(queue.poll());
        System.out.println(queue.size());

    }
}
