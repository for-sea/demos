package com.demo.treetableview;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Demo {
    public static void main(String[] args) {
        LocalDateTime startDate = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 12, 31, 23, 59, 59);
        long betweenMonth = ChronoUnit.MONTHS.between(startDate, endDate);
        System.out.println(betweenMonth);
        LocalDateTime startDay = LocalDateTime.of(2024, 11, 1, 0, 0, 0);
        LocalDateTime endDay = LocalDateTime.of(2024, 11, 30, 23, 59, 59);
        long betweenDay = ChronoUnit.DAYS.between(startDay, endDay);
        System.out.println(betweenDay);
        LocalDateTime startTime = LocalDateTime.of(2024, 11, 27, 0, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 11, 27, 23, 59, 59);
        long betweenTime = ChronoUnit.HOURS.between(startTime, endTime);
        System.out.println(betweenTime);
    }
}
