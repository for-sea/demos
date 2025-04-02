package com.demo.netDemo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP通信客户端3
 */
public class TcpClient3 {
    public static void main(String[] args) {
        System.out.println("---客户端启动---");
        try {
            // 1. 创建Socket对象，并同时请求与服务器程序的连接
            Socket socket = new Socket("127.0.0.1", 8888);
            // 2. 获取字节输出流，发送数据给服务器端
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            // 3. 发送数据
            while (true) {
                System.out.println("请输入：");
                String line = new Scanner(System.in).nextLine();
                if ("exit".equals(line)) {
                    System.out.println("感谢使用，再见！");
                    dos.close();
                    socket.close();
                    break;
                }
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
