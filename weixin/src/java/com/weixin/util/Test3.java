/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

/**
 *
 * @author Administrator
 */
public class Test3 {
    public static String str1 = "abc";
    public static final String str2 = "def";
    
    public static void main(String agrs[]){
        
        String str3 = str1 + "123";
        String str4 = str2 + "123";
        str1  = "abc111";
       // str2 = "def222"; //str2为final，不可更改
        
        System.out.println("-----str3:"+str3);
        System.out.println("-----str4:"+str4);
        System.out.println("-----str1:"+str1);
        
        
    }
    
}
