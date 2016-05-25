/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sockets.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 客户端写服务端读----服务端代码
 * @author Administrator
 */
public class Server1 {
    
    public static void main(String agrString[]) throws IOException {
        //为了简单，所有的异常都往外抛
        int port = 8899;
        //定义一个ServerSocket监听在端口8899上
        ServerSocket server = new ServerSocket(port);
        //server尝试接受其他socket的连接请求，server的accept方法是阻塞式的
        Socket socket = server.accept(); 
        //跟客户端建立好连接之后，我们就可以获取socket的inputstream，并从中读取客户端发来的信息
        
        Reader reader = new InputStreamReader(socket.getInputStream()); 
        char chars[] = new char[64];
        int len;
        
        StringBuilder sb = new StringBuilder();
        
        while((len=reader.read(chars)) !=-1){
            sb.append(new String(chars, 0, len));
        }
        System.out.println("From Client:"+ sb);
        reader.close();
        socket.close();
        server.close();
        
    }
    
}
