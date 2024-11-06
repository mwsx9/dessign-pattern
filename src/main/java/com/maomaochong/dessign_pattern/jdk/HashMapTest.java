package com.maomaochong.dessign_pattern.jdk;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        System.out.println("HashMapTest");

        Map<String, String> hashMap = new HashMap<String, String>(10, 0.75F);
    }
}
