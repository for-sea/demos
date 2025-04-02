package com.demo.netDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpClient2 {
    public static void main(String[] args) throws Exception {
        System.out.println("---客户端启动---");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 获取用户输入
            System.out.println("输入数据：");
            String str = scanner.nextLine();
            // 2. 创建客户端对象
            DatagramSocket socket = new DatagramSocket();
            if ("exit".equals(str)) {
                System.out.println("---客户端关闭，已退出---");
                socket.close();
                break;
            }
            // 3. 创建数据包对象，封装数据
            byte[] bytes = str.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 7777);
            socket.send(packet);
            System.out.println("数据已发送");
        }
    }
}
