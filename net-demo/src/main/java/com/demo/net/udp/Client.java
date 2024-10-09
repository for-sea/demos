package com.demo.net.udp;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端
 */
public class Client {
    @Test
    public void testDatagramSocket() throws Exception {
        // 1. 创建客户端对象
        DatagramSocket socket = new DatagramSocket();
        // 2. 创建数据包对象
        String str = "要做神仙，驾鹤飞天";
        byte[] bytes = str.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);
        // 3. 发送
        socket.send(packet);
        System.out.println("--- 客户端发送完毕 ---");
        // 4. 关闭客户端
        socket.close();
    }
}
