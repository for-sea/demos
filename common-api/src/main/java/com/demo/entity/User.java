package com.demo.entity;

public class User implements Cloneable{
    private Long id;

    private String username;

    private double[] scores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    /*// 浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }*/

    // 深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        User u2 = (User) super.clone();
        u2.scores = u2.scores.clone();
        return u2;
    }
}
