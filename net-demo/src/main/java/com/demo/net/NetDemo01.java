package com.demo.net;

import org.junit.Test;

import java.net.InetAddress;

/**
 * 通信三要素API：IP、端口号、协议
 */
public class NetDemo01 {
    @Test
    public void testInetAddress() throws Exception {
        // 获取localhost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        // 获取指定IP
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println(ip);
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
        // 检测IP是否可达（相当于ping）
        System.out.println(ip.isReachable(6000));
    }

}
