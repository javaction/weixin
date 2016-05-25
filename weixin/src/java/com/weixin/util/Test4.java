/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

import org.hibernate.validator.constraints.Length;

/**
 * 我们都是小青蛙，咕咕呱呱呱~
 * @author Administrator
 */
public class Test4 {
 
    
    
    
    public static void main(String agrString[]){
             
//        java如何获得指定位数  处的字符串
//注意是指定位数 ，不是指定长度，位数有全角半角之分
//怎么截取指定位数的字符串呢？
    
        String str = "abcdefgh12345";
    //    String s1 = str.substring(beginIndex, endIndex);
        int i = str.indexOf("a");
        System.out.println("下标："+i);
        
        String ss = "中国123";
        int m = ss.indexOf("1");
        System.out.println("mm:"+m);
       
        int a = ss.toCharArray().length;
        System.out.println("aaaaa:"+a);
        

        
//        String sss = "中国１２３";
//        int n = sss.indexOf("１");
//        System.out.println("n:"+n);
        
//             int arr[][] = new int[][] { { 1 }, { 1, 2 }, { 1, 2, 3 } };
//             for(int i =0; i<arr.length ;i++){
//                 int arr2[] = arr[i];
//                 for(int j =0; j<arr2.length ; j++){
//                     System.out.print(arr2[j]);
//                 }
//                 System.out.print("\n");
//             }
         
         }
    
    
}
