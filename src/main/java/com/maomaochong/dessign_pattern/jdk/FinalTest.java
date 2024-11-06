package com.maomaochong.dessign_pattern.jdk;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {
    public static void main(String[] args) {
        final List<String> srLis = new ArrayList<>();
        srLis.add("Hello");
        srLis.add("world");
        List<String> unmodifableStrLis = com.sun.tools.javac.util.List.of("hello", "world");
        unmodifableStrLis.add("again");
    }
}
