package com.demo.netDemo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 负责处理客户端Socket通信的线程
 */
public class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            // 读取客户端发送的消息
            while (true) {
                try {
                    String str = dis.readUTF();
                    System.out.println(str);
                    sendMsgToAll(str);
                } catch (IOException e) {
                    // 检测到客户端关闭，从在线列表中移除客户端，关闭资源
                    System.out.println("---客户端已经关闭---");
                    TcpServer4.onlineClients.remove(socket);
                    dis.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 给所有在线的客户端发送消息
     * @param str 某一客户端发送的消息
     */
    private void sendMsgToAll(String str) {
        for (Socket socket : TcpServer4.onlineClients) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(str);
                dos.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
