package com.demo.netDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpServer4 {
    public static List<Socket> onlineClients = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("---服务器启动---");
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("新用户" + socket.getInetAddress().getHostAddress() + "连接");
                onlineClients.add(socket);
                new ServerReaderThread(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
