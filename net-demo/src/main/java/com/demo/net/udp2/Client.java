package com.demo.net.udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        // 1. 创建客户端
        DatagramSocket socket = new DatagramSocket();
        // 2. 输入数据，封装成packet
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入：");
            String line = scanner.nextLine();
            // 若输入exit，则退出
            if ("exit".equals(line)) {
                System.out.println("感谢使用，再见！");
                socket.close();
                break;
            }
            byte[] bytes = line.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);
            socket.send(packet);
        }
    }
}
