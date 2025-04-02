package com.demo.netDemo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer1 {
    public static void main(String[] args) throws Exception {
        System.out.println("---服务器端启动---");
        // 1. 创建ServerSocket对象，并注册端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2. 调用accept方法，获取Socket对象
        Socket socket = serverSocket.accept();
        // 3. 获取字节输入流，封装成数据输入流
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        // 4. 读取客户端发送的消息及客户端IP
        String str = dis.readUTF();
        System.out.println(socket.getInetAddress() + ":" + str);
        // 5. 关闭资源
        dis.close();
        socket.close();
    }
}
