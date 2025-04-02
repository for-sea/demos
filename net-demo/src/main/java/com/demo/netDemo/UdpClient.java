package com.demo.netDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("---客户端启动---");
        // 1. 创建客户端对象
        DatagramSocket socket = new DatagramSocket();

        // 2. 创建数据包对象，封装数据
        byte[] bytes = "你说你不想在这里，我也不想在这里".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);

        // 3. 发送数据
        socket.send(packet);
        System.out.println("---客户端发送完毕---");
    }
}
