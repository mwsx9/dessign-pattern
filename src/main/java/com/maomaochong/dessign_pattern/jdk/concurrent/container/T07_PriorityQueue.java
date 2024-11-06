package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.PriorityQueue;
import java.util.Queue;

public class T07_PriorityQueue {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("c");
        queue.add("e");
        queue.add("a");
        queue.add("d");
        queue.add("z");
        queue.add("i");

        int length = queue.size();
        for (int i = 0; i < length; i++) {
            System.out.println(queue.poll());
        }
    }
}
