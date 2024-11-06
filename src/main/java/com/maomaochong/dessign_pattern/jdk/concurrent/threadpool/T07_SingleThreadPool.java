package com.maomaochong.dessign_pattern.jdk.concurrent.threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T07_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int j = i;
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "###" + j);
            });
        }
    }
}
