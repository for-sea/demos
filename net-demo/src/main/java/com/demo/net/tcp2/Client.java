package com.demo.net.tcp2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP通信：多手多发-客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 1. 创建客户端，请求与服务端建立连接
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2. 创建输出流
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        // 3. 发送数据
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入：");
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                System.out.println("感谢使用，再见！");
                dataOutputStream.close();
                socket.close();
                break;
            }
            dataOutputStream.writeUTF(line);
            dataOutputStream.flush();
        }
    }
}
