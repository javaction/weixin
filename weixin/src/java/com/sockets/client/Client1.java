/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sockets.client;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * 客户端写服务端读----客户端代码
 * @author Administrator
 */
public class Client1 {
    
    public static void main(String agrsString[]) throws  Exception{
        //为了简单起见，所有异常都往外抛
        String host = "127.0.0.1"; //要连接的服务器ip地址
        int port = 8899; //要连接的服务端对应的监听端口
        //与服务端建立连接
        Socket client = new Socket(host, port);
        //建立连接后就可以往服务端写数据了
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("hello world. ＨＥＬＬＯ　ＷＯＲＬＤ");
        writer.flush();//记得flush()
        writer.close();
        client.close();
        
    }
    
}
