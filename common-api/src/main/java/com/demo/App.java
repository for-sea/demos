package com.demo;

import com.demo.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        String format1 = format.format(date);
        System.out.println(format1);
        String format2 = format.format(time);
        System.out.println(format2);
    }
}
