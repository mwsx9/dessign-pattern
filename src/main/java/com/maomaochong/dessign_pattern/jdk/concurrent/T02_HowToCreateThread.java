package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class T02_HowToCreateThread {

    // 启动线程的5种方式
    public static void main(String[] args) {
        // 1，Thread.start;
        new MyThread().start();

        // 2，thread封装runnable
        new Thread(new MyRun()).start();

        // 3, 函数式编程
        new Thread(() -> {
            System.out.println("Hello Lambda");
        }).start();

        // 4，future
        new Thread(new FutureTask<String>(new MyCall())).start();

        // 5, 线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("Hello ThreadPool");
        });
        executorService.shutdown();
    }

    // 创建线程1：扩展Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    // 创建线程2：实现Runable接口
    static class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    // 创建线程3：回调线程
    static class MyCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall!");
            return "success";
        }
    }
}
