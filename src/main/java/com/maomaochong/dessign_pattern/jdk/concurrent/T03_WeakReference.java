package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.lang.ref.WeakReference;

public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> threadLocal = new ThreadLocal<>();
        threadLocal.set(new M());

        ThreadLocal<M> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set(new M());

        threadLocal.remove();
        threadLocal2.remove();
    }
}
