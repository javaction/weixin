/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

import java.io.File;

/**
 * 用于一些简单例子的测试2
 * @author Administrator
 */
public class Test2 {
    //阶乘计算
    public static  int jc(int i){
        int c = 0;
        if(i == 0){
            c = 1;
        }else{
            System.out.println("------阶乘---"+(i-1));
            c = i * jc(i-1);
        }
        
        return c;
    }
    
    public static void main(String agrs[]){
//        String path = System.getProperty("java.io.tmpdir") + File.separator;
//        String path1 = System.getProperty("java.io.tmpdir");
//        String path2 = File.separator;
//        
//        System.out.println("------path---"+path);
//        System.out.println("------path1---"+path1);
//        System.out.println("------path2---"+path2);
        
        int m = Test2.jc(5);
        System.out.println("------阶乘---"+m);
        
        
    }
    
    
}
