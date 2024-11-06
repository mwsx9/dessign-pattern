package com.maomaochong.dessign_pattern.jdk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ReflectTest {

    public static void base() {
        // getClass方法
        String name = "Huanglinqing";
        Class c1 = name.getClass();
        System.out.println(c1);

        // Class.forName
        try {
            String classname = "java.lang.String";
            c1 = Class.forName(classname);
            System.out.println(c1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void constructors() {
        Test test = new Test();
        Class c4 = test.getClass();
        Constructor[] constructors = c4.getDeclaredConstructors();
        System.out.println(constructors);

        for (int i = 0; i < constructors.length; i++) {
            System.out.print(Modifier.toString(constructors[i].getModifiers()) + "参数：");
            Class[] parametertypes = constructors[i].getParameterTypes();
            for (int j = 0; j < parametertypes.length; j++) {
                System.out.print(parametertypes[j].getName() + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Class c4 = test.getClass();

        Class[] p = {int.class, String.class};
        try {
            Constructor constructors = c4.getDeclaredConstructor(p);
            constructors.setAccessible(true);
            Test test1 = (Test) constructors.newInstance(24, "HuangLinqing");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
