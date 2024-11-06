package com.maomaochong.dessign_pattern.jdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
    public static void main(String[] args) throws Exception {
        NameStore nameStore0 = new NameStore("Steve", "Middle", "Jobs");
        String json = JSON.toJSONString(nameStore0);
        System.out.println(json);

        nameStore0 = JSONObject.parseObject(json, NameStore.class);
        System.out.println(nameStore0);

        // 如果一个变量被申明为 transient，那么这个变量就不会被序列化。
        NameStore nameStore = new NameStore("Steve", "Middle", "Jobs");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("nameStore"));
        // writing to object
        o.writeObject(nameStore);
        o.close();

        // reading from object
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("nameStore"));
        NameStore nameStore1 = (NameStore) in.readObject();
        System.out.println(nameStore1);
    }
}