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
 * 客户端和服务端同时写----服务端代码 --不完善
 * @author Administrator
 */
public class Server2 {
    
    public static void main(String agrString[]) throws IOException {
        //为了简单起见，所有的异常信息都往外抛
        int port = 8899;
        //定义一个ServerSocket监听在端口8899上
        ServerSocket server = new ServerSocket(port);
        //server 尝试接收其他socket的连接请求，server的accept方法是阻塞式的
        Socket socket = server.accept();
        //跟客户端建立好连接之后，我们就可以获取socket的inputstream，并从中读取客户端发过来的信息了
        //--***-- 从输入流中读取数据是一个阻塞式操作 ,
        Reader reader = new InputStreamReader(socket.getInputStream());
        char[] chars = new char[64];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len=reader.read(chars)) != -1){
            sb.append(new String(chars, 0, len));
        }
        System.out.println("From Client:"+sb);
        
        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        writer.write("ｈｅｌｌｏ　ｗｏｒｌｄ");
        writer.flush();
        reader.close();
        writer.close();
        socket.close();
        server.close();
    }
    
}
