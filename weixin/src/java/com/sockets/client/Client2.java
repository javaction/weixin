/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sockets.client;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class Client2 {
    
    public static void main(String agrsString[]) throws Exception{
        
        //为了简单起见，所有的异常都抛出
        String host = "127.0.0.1"; //要连接的服务端ip地址
        int port = 8899; //要连接的服务端对应的监听接口
        //与服务端建立连接
        Socket socket = new Socket(host, port);
        
        //建立连接后可以往服务端写数据了
        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        writer.write("hello server...");
        writer.write("eof");
        writer.flush();
        
        //写完之后，进行读的操作
        Reader reader = new InputStreamReader(socket.getInputStream());
        char[] chars = new char[64];
        int len;
        StringBuilder sb = new StringBuilder();
        String temp;
        int index;
        
        //////----后续，，
        
        
    }
    
}
