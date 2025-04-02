package com.demo.netDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("---服务端启动---");
        // 1. 创建一个服务端对象，注册端口
        DatagramSocket socket = new DatagramSocket(6666);

        // 2. 创建一个数据包，用于接收客户端发送的数据，需要定义数据包大小
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 3. 接收数据
        socket.receive(packet);

        // 4. 输出数据：接收多少输出多少
        int length = packet.getLength();
        String data = new String(buffer, 0, length);
        System.out.println(data);

        // 5. 可以输出客户端IP端口信息
        System.out.println("--消息来自客户端：" + packet.getAddress().getHostName() + " "
                + packet.getAddress().getHostAddress() + ":" + packet.getPort());

        // 6. 关闭资源
        socket.close();
    }
}
