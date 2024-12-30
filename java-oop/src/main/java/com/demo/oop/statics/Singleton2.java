package com.demo.oop.statics;

public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2(){}

    private static Singleton2 getSingleton2() {
        if (null == singleton2) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
