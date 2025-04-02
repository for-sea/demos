package com.demo.netDemo;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient4 {
    public static void main(String[] args) {
        System.out.println("---客户端启动---");
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            // 创建一个线程，用于读取服务器端发送过来的消息
            new ClientReaderThread(socket).start();
            // 向服务端发送数据
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入：");
                String line = scanner.nextLine();
                // 输入exit，退出
                if ("exit".equals(line)) {
                    System.out.println("感谢使用，再见！");
                    dos.close();
                    socket.close();
                    break;
                }
                // 向服务端发送数据
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
