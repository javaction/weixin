/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sockets.server;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试使用cmd命令运行java文件
 * @author Administrator
 */
public class CmdTest1 {
    
    public static void main(String agrString[]) throws Exception{
        // D:\mytestgit\weixin\weixin\src\java\com\sockets\server
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = new Date();        
        String dateStr = sdf.format(date);
      //  System.out.println("===[测试使用cmd命令运行java文件,测试时间为："+dateStr+"]===");
        System.out.println("===[test for cmd , the time is :"+dateStr+"]===");
    }
    
}
