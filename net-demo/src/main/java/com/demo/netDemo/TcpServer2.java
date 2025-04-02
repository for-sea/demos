package com.demo.netDemo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {
    public static void main(String[] args) throws Exception {
        System.out.println("---服务器启动---");
        // 1. 创建服务器对象
        ServerSocket serverSocket = new ServerSocket(8888);

        // 2. 获取Socket对象
        Socket socket = serverSocket.accept();

        // 3. 获取字节输入流，封装成数据输入流
        InputStream is = socket.getInputStream();
        DataInputStream dis = new java.io.DataInputStream(is);

        // 4. 读取客户端发送的消息
        while (true) {
            try {
                String str = dis.readUTF();
                System.out.println(str);
            } catch (IOException e) {
                // 检测到客户端关闭，关闭资源
                System.out.println("---客户端已经关闭---");
                socket.close();
                dis.close();
                break;
            }
        }
    }
}
