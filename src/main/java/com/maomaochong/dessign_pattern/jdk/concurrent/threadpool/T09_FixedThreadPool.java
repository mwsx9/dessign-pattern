package com.maomaochong.dessign_pattern.jdk.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class T09_FixedThreadPool {
    public static void main(String[] args) {
        int core = Runtime.getRuntime().availableProcessors();
        System.out.println(core);

        long start = System.currentTimeMillis();
        List<Integer> results = getPrime(1, 20000000);
        long end = System.currentTimeMillis();
        System.out.println("单核执行=" + (end - start) + " 个数=" + results.size());

        start = System.currentTimeMillis();
        MyPrimeTask myPrimeTask1 = new MyPrimeTask(1, 5000000);
        MyPrimeTask myPrimeTask2 = new MyPrimeTask(5000000 + 1, 10000000);
        MyPrimeTask myPrimeTask3 = new MyPrimeTask(10000000 + 1, 15000000);
        MyPrimeTask myPrimeTask4 = new MyPrimeTask(15000000 + 1, 20000000);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<List<Integer>> future1 = executorService.submit(myPrimeTask1);
        Future<List<Integer>> future2 = executorService.submit(myPrimeTask2);
        Future<List<Integer>> future3 = executorService.submit(myPrimeTask3);
        Future<List<Integer>> future4 = executorService.submit(myPrimeTask4);

        try {
            List<Integer> result1 = future1.get();
            List<Integer> result2 = future2.get();
            List<Integer> result3 = future3.get();
            List<Integer> result4 = future4.get();

            end = System.currentTimeMillis();
            System.out.println("4核=" + (end - start) + " 个数=" + (result1.size() + result2.size() + result3.size() + result4.size()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }

    private static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                results.add(i);
            }
        }

        return results;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    static class MyPrimeTask implements Callable<List<Integer>> {
        private int start;
        private int end;

        public MyPrimeTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() {
            List<Integer> results = getPrime(start, end);
            return results;
        }
    }
}
