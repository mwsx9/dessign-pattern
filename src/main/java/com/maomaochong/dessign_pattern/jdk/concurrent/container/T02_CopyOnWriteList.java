package com.maomaochong.dessign_pattern.jdk.concurrent.container;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        List<String> lists = new CopyOnWriteArrayList<>();
    }
}
