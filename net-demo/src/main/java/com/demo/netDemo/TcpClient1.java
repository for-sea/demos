package com.demo.netDemo;

import java.io.*;
import java.net.Socket;

/**
 * TCP客户端
 */
public class TcpClient1 {
    public static void main(String[] args) throws Exception {
        System.out.println("---客户端启动---");
        // 1. 创建Socket对象，并同时请求与服务器程序的连接
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2. 获取字节输出流，发送数据给服务器端
        OutputStream os = socket.getOutputStream();
        // 3. 将低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);
        // 4. 发送数据
        dos.writeUTF("你好，我是客户端");
        // 5. 关闭流及套接字
        dos.close();
        socket.close();
    }
}
