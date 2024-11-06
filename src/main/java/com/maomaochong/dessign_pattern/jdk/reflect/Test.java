package com.maomaochong.dessign_pattern.jdk.reflect;

public class Test {
    private int age;
    private String name;
    private int testInt;

    public Test(int age, String name, int testInt) {
        this.age = age;
        this.name = name;
        this.testInt = testInt;
    }

    private Test(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("hello " + name + ". i am " + age);
    }

    private Test(int age) {
        this.age = age;
        System.out.println("My age is" + age);
    }

    public Test() {
    }
}
