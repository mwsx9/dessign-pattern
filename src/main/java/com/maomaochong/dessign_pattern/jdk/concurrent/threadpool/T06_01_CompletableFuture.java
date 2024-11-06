package com.maomaochong.dessign_pattern.jdk.concurrent.threadpool;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class T06_01_CompletableFuture {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CompletableFuture<BigDecimal> futureTm = CompletableFuture.supplyAsync(() -> priceOfTm());
        CompletableFuture<BigDecimal> futureTb = CompletableFuture.supplyAsync(() -> priceofTb());
        CompletableFuture<BigDecimal> futureJd = CompletableFuture.supplyAsync(() -> priceofJd());
        CompletableFuture<BigDecimal> futureAmazon = CompletableFuture.supplyAsync(() -> priceOfAmazon());

        CompletableFuture.allOf(futureTm, futureTb, futureJd, futureAmazon).join();

        System.out.println("耗时=" + (System.currentTimeMillis() - start));
        try {
            System.out.println(futureTm.get() + "#" + futureTb.get() + "#" + futureJd.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static BigDecimal priceOfAmazon() {
        delay();
        // throw new RuntimeException("product not exist");
        return BigDecimal.ONE;
    }

    private static BigDecimal priceofJd() {
        System.out.println("jd_" + Thread.currentThread().getName());
        delay();
        return new BigDecimal("3.0");
    }

    private static BigDecimal priceofTb() {
        System.out.println("tb_" + Thread.currentThread().getName());

        delay();
        return new BigDecimal("2.0");
    }

    private static BigDecimal priceOfTm() {
        System.out.println("tm_" + Thread.currentThread().getName());

        delay();
        return new BigDecimal("1.00");
    }

    private static void delay() {
        Random random = new Random(System.currentTimeMillis());
        try {
            int sleep = random.nextInt(1000);
            System.out.println("sleep=" + sleep);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
