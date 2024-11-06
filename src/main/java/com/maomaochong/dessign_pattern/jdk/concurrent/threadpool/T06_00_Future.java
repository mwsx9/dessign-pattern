package com.maomaochong.dessign_pattern.jdk.concurrent.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class T06_00_Future {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(1);
            return "OK";
        });

        new Thread(futureTask).start();

        try {
            System.out.println(LocalDateTime.now());
            System.out.println(futureTask.get());
            System.out.println(LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
