package com.demo.net.tcp;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP通信：客户端
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 创建客户端，初始化服务IP端口，请求与服务器建立连接
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2. 获取字节输出流，发送数据给服务端
        OutputStream outputStream = socket.getOutputStream();
        // 3. 将低级的输出流包装成数据输出流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        // 4. 发送数据
        dataOutputStream.writeUTF("我发一条消息");
        // 5. 关闭流及套接字
        dataOutputStream.close();
        socket.close();
    }
}
