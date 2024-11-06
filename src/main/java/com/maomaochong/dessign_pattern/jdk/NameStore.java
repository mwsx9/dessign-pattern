package com.maomaochong.dessign_pattern.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameStore implements Serializable {
    private String firstName;
    // 如果一个变量被申明为 transient，那么这个变量就不会被序列化。
    private transient String middleName;
    private String lastName;
}
