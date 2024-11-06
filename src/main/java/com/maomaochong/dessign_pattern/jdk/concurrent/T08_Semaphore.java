package com.maomaochong.dessign_pattern.jdk.concurrent;

import java.util.ArrayList;
import java.util.List;

public class T08_Semaphore {
    volatile private List<Object> list = new ArrayList<>(10);

    public void add(Object value) {
        if (value == null) {
            return;
        }

        list.add(value);
    }

    public int size() {
        return list.size();
    }



}
