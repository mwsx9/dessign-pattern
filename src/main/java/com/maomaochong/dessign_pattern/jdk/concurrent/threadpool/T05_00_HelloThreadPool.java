package com.maomaochong.dessign_pattern.jdk.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T05_00_HelloThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                (r, executor) -> {
                    MyTask myTask = (MyTask) r;
                    System.out.println("rejectedExecution" + "###################" + myTask.value);
                });

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new MyTask(i));
        }

        System.out.println(threadPoolExecutor.getQueue());
        threadPoolExecutor.execute(new MyTask(100));
        System.out.println(threadPoolExecutor.getQueue());

        threadPoolExecutor.shutdown();
    }


    static class MyTask implements Runnable {
        private int value;

        public MyTask(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "#task#" + value);
        }
    }
}
