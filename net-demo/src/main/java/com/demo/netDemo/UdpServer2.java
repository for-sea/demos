package com.demo.netDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer2 {
    public static void main(String[] args) throws Exception {
        System.out.println("---服务器启动---");
        // 1. 创建服务器对象
        DatagramSocket socket = new DatagramSocket(7777);
        while (true) {
            // 2. 创建一个数据包，用于接收客户端发送的数据，需要定义数据包大小
            byte[] buffer = new byte[1024 * 64];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            // 3. 接收数据
            socket.receive(packet);
            // 4. 获取数据
            int length = packet.getLength();
            String str = new String(buffer, 0, length);
            System.out.println("接收数据：" + str);
            System.out.println("--来自：" + packet.getAddress().getHostName() + " "
                    + packet.getAddress().getHostAddress() + ":" + packet.getPort());
        }
    }
}
