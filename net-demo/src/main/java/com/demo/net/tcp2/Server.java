package com.demo.net.tcp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * TCP通信：多发多收-服务端
 */
public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("--- 启动服务端 ---");
        // 1. 新建服务端，获取输入流
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        // 2. 读取数据
        while (true) {
            try {
                String str = dataInputStream.readUTF();
                SocketAddress socketAddress = socket.getRemoteSocketAddress();
                System.out.println("输出：" + str + " from " + socketAddress);
            } catch (IOException e) {
                System.out.println(socket.getRemoteSocketAddress() + "离线了");
                dataInputStream.close();
                socket.close();
                break;
            }
        }
    }
}
