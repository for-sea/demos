package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬取信息
 */
public class Demo2 {
    public static void main(String[] args) {
        String text = "The event starts at 2023-10-05 14:30:00 and ends at 2023-10-05 16:45:00.";
        String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found datetime: " + matcher.group());
        }
    }
}
