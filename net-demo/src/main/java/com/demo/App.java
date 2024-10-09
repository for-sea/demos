package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        List<Integer> integers = Collections.nCopies(3, 1);
//        integers.add(0);
        List<Integer> integers = new ArrayList<>(Collections.nCopies(96, null));
        integers.add(0);
        System.out.println(integers);
    }
}
