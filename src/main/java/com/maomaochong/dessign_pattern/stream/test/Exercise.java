package com.maomaochong.dessign_pattern.stream.test;

import com.maomaochong.dessign_pattern.stream.data.Data;
import com.maomaochong.dessign_pattern.stream.data.Person;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise {
    public static void main(String[] args) {
        // 1. 所有及格的学生信息
        List<Person> list1 = Data.getData().stream().filter(ele -> ele.getScore() >= 60).collect(Collectors.toList());
        // System.out.println(list1);

        // 2. 所有及格学生的姓名
        List<String> list2 = Data.getData().stream().filter(ele -> ele.getScore() >= 60).map(ele -> ele.getName()).collect(Collectors.toList());
        // System.out.println(list2);

        // 3. 班级的后3名
        List<Person> list3 = Data.getData().stream().sorted(Comparator.comparingInt(Person::getScore)).limit(3).collect(Collectors.toList());
        // System.out.println(list3);

        // 4. 班级的3-10名
        List<Person> list4 = Data.getData().stream().sorted((ele1, ele2) -> ele2.getScore() - ele1.getScore()).skip(2).limit(8).collect(Collectors.toList());
        // System.out.println(list4);

        // 5. 所有不及格的学生的平均成绩
        List<Person> list5 = Data.getData().stream().filter(ele -> ele.getScore() < 60).collect(Collectors.toList());
        Person temp = new Person();
        list5.stream().reduce((ele1, ele2) ->
        {
            temp.setScore(ele1.getScore() + ele2.getScore());
            return temp;
        });

        // 6. 转map
        Map<String, Person> map = Data.getData().stream().collect(Collectors.toMap(Person::getName, ele->ele));
        //System.out.println(map);

        Data.getData().stream().collect(Collectors.summarizingInt(Person::getScore));
        Data.getData().stream().collect(Collectors.averagingDouble(Person::getScore));

        IntSummaryStatistics intSummaryStatistics = Data.getData().stream().collect(Collectors.summarizingInt(Person::getScore));
        System.out.println(intSummaryStatistics);
    }
}
