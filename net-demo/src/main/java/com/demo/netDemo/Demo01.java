package com.demo.netDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        // 1. 获取本机的IP对象
        InetAddress ip1 = InetAddress.getLocalHost();
        // 1.1 获取IP对象的主机名
        System.out.println(ip1.getHostName());
        // 1.2 获取IP对象的IP地址
        System.out.println(ip1.getHostAddress());

        // 2. 获取指定IP或指定域名的IP对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());

        // 3. 判断IP是否可达
        System.out.println(ip2.isReachable(6000));
    }
}
