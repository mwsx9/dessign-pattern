package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.io.IOException;

public class T01_NormalReference {
    public static void main(String[] args) {
        M m = new M();

        m = null;
        System.gc();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
