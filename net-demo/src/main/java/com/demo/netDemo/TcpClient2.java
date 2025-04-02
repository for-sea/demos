package com.demo.netDemo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP客户端通信2
 */
public class TcpClient2 {
    public static void main(String[] args) throws Exception {
        System.out.println("---客户端启动---");
        // 1. 创建Socket对象，并同时请求与服务器程序的连接
        Socket socket = new Socket("127.0.0.1", 8888);

        // 2. 获取字节输出流，发送数据给服务器端
        OutputStream os = socket.getOutputStream();

        // 3. 将低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        // 4. 循环发送数据，输入exit退出
        while (true) {
            System.out.println("输入数据：");
            String str = new java.util.Scanner(System.in).nextLine();
            if ("exit".equals(str)) {
                System.out.println("---客户端关闭，已退出---");
                dos.close();
                socket.close();
                break;
            }
            dos.writeUTF(str);
        }
    }
}
