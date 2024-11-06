package com.maomaochong.dessign_pattern.stream.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Person> getData() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("xiaoming", 10, 100));
        list.add(new Person("xiaoli", 12, 90));
        list.add(new Person("xiaowang", 9, 80));
        list.add(new Person("xiaozhang", 11, 70));
        list.add(new Person("xiaomei", 7, 95));
        list.add(new Person("xiaohei", 13, 60));
        list.add(new Person("xiaohei2", 13, 60));
        return list;
    }
}
