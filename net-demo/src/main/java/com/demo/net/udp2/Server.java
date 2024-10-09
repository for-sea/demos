package com.demo.net.udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception{
        System.out.println("--- 启动服务端 ---");
        // 1. 创建服务端
        DatagramSocket socket = new DatagramSocket(6666);
        // 2. 接收数据
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        while (true) {
            socket.receive(packet);
            int length = packet.getLength();
            String str = new String(buffer, 0, length);
            System.out.println("输出：" + str);
            System.out.println(packet.getAddress() + ":" + packet.getPort());
        }
    }
}
