package com.maomaochong.dessign_pattern.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassloaderTest {
    private String p = "test";

    public static void main(String[] args) {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null) {
                    return super.loadClass(name);
                }

                try {
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        };

        try {
            Object object = myLoader.loadClass("com.maomaochong.dessign_pattern.jvm.ClassloaderTest").newInstance();
            System.out.println(object.getClass());
            System.out.println(object instanceof com.maomaochong.dessign_pattern.jvm.ClassloaderTest);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
