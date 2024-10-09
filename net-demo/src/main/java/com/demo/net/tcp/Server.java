package com.demo.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * TCP通信：服务端
 */
public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("--- 启动服务端 ---");
        // 1. 创建服务端，注册服务端端口
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2. 使用ServerSocket.accept方法，阻塞等待客户端连接
        Socket socket = serverSocket.accept();
        // 3. 获取字节输入流，封装成数据输入流
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // 4. 读取客户端发送的消息及客户端IP
        String str = dataInputStream.readUTF();
        SocketAddress address = socket.getRemoteSocketAddress();
        System.out.println(str);
        System.out.println(address);
        dataInputStream.close();
        serverSocket.close();
    }
}
