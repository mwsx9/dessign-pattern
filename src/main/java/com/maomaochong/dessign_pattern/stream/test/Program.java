package com.maomaochong.dessign_pattern.stream.test;

import com.maomaochong.dessign_pattern.stream.data.Data;
import com.maomaochong.dessign_pattern.stream.data.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        Person xiaoming = new Person("xiaoming", 10, 100);

        // 三个步骤：
        // 1,获取数据源：集合、数组
        // 2,对数据进行处理的过程：过滤、排序、映射--中间操作
        // 3,对流中的数据进行集合处理--最终操作

        //Stream<Person> s = Data.getData().stream();

        // 最终操作1 collect
        //s.collect(Collectors.toList());

        // Data.getData().stream().filter(ele->ele.getAge() > 10).forEach(System.out::println);
        // Data.getData().stream().distinct().forEach(System.out::println);
        // Data.getData().stream().sorted(Comparator.comparingInt(Person::getScore)).forEach(System.out::println);
        // Data.getData().stream().map(Person::getName).forEach(System.out::println );

        // 并行流
        // Data.getData().parallelStream();
//        long start = System.currentTimeMillis();
//        LongStream.rangeClosed(0L, 10000000000L).reduce(Long::sum);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

        // System.out.println(Data.getData().stream().findAny());
        // System.out.println(Data.getData().parallelStream().findAny());

        String[] array = {"hello", "world"};
        System.out.println(Arrays.stream(array).map(ele->ele.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
    }
}
