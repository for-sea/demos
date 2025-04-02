package com.demo.netDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 服务器端：支持多个客户端同时连接
 */
public class TcpServer3 {
    public static void main(String[] args) {
        System.out.println("---服务器端启动---");
        try {
            // 1. 创建服务器端ServerSocket对象，并绑定监听端口
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                // 2. 调用ServerSocket对象的accept方法，获取Socket对象
                Socket socket = serverSocket.accept();
                // 3. 创建线程，读取客户端发送的数据
                new ServerReaderThread(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
