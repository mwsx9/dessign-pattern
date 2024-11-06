package com.maomaochong.dessign_pattern.jdk.concurrent;

public class M {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }
}
