package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User implements Cloneable{
    private Long id;

    private String username;

    private double score;

  /*// 浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }*/

    /*// 深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        User u2 = (User) super.clone();
        u2.scores = u2.scores.clone();
        return u2;
    }*/
}
