package com.demo.net.udp;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务端
 */
public class Server {
    @Test
    public void testDatagramSocket() throws Exception {
        System.out.println("--- 启动服务端 ---");
        // 1. 创建服务端对象，注册端口
        DatagramSocket socket = new DatagramSocket(6666);
        // 2. 创建数据包对象，接受数据
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        // 3. 使用数据包接收数据
        socket.receive(packet);
        // 4. 读取数据（接收多少数据就读取多少）
        int length = packet.getLength();
        String str = new String(buffer, 0, length);
        System.out.println("接收到数据：" + str);
        // 5. 可以获取服务端IP端口
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        System.out.println("客户端IP端口：" + address + ":" + port);

        socket.close();
    }
}
