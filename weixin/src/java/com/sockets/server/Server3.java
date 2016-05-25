/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sockets.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端和服务端同时写----服务端代码
 * @author Administrator
 */
public class Server3 {
    
    public static void main(String agrString[]) throws IOException{
        int port = 8899;
        //定义一个serverSocket监听在端口8899上
        ServerSocket server = new ServerSocket(port);
        //server尝试接收其他socket的连接请求，server的accept的方法是阻塞的
        Socket socket = server.accept();
        //跟客户端建立好连接后，我们就可以获取socket的inputstream，并从中读取客户端发来的信息了
        
        Reader reader = new InputStreamReader(socket.getInputStream()); 
        char[] chars = new char[64];
        int len;
        StringBuilder sb =  new StringBuilder();
        String temp;
        int index;
        while((len=reader.read(chars))!=-1){ 
            temp = new String(chars, 0, len);
            if((index = temp.indexOf("eof"))!=-1){ //遇到eof时就结束接收
                sb.append(temp.substring(0, index));
                break;
            }
            sb.append(temp);
        }
        System.out.println("from client:"+sb.toString());
        
        //读完后写一句
        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        writer.write("ＨＥＬＬＯ　ＷＯＲＬＤ");
        writer.flush();
        writer.close();
        reader.close();
        socket.close();
        server.close();
        
    }
    
}
