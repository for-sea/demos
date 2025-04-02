package com.demo.old;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 倒计时（旧时间日期API）
 * 1. 显示当前年月日时分秒、星期几
 * 2. 距离下班
 * 3. 距离周末
 * 4. 距离发工资
 * 5. 距离节假日
 * 6. 美国当前时间
 */
public class CountdownByOldApi {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下班时间，如 18:00");
        String knockOffTimeStr = scanner.nextLine();
        System.out.println("请输入发薪日，如 10 代表每月10号发薪");
        String salaryDateStr = scanner.nextLine();
        // 1. 当前时间
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
        String currTimeStr = formatter1.format(now.getTime());
        System.out.println("当前时间为：" + currTimeStr);
        // 2. 距离下班的时间
        Calendar knockOffTime = Calendar.getInstance();
        String[] knockOffTimeStrArray = knockOffTimeStr.split(":");
        knockOffTime.set(Calendar.HOUR, Integer.parseInt(knockOffTimeStrArray[0]));
        knockOffTime.set(Calendar.MINUTE, Integer.parseInt(knockOffTimeStrArray[1]));
        knockOffTime.set(Calendar.SECOND, 0);
        long differenceInMillis = knockOffTime.getTimeInMillis() - now.getTimeInMillis();
        long differenceInSeconds = differenceInMillis / 1000;
        long days = differenceInSeconds / (24 * 3600);
        differenceInSeconds %= (24 * 3600);
        long hours = differenceInSeconds / 3600;
        differenceInSeconds %= 3600;
        long minutes = differenceInSeconds / 60;
        long seconds = differenceInSeconds % 60;
        System.out.println("下班时间：" + formatter1.format(knockOffTime.getTime()));
        System.out.println("距离下班: " + days + "天 " + hours + "小时 " + minutes + "分钟 " + seconds + "秒");
    }
}
