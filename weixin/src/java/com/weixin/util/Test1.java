/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

/**
 * 
 * @author Administrator
 */
public class Test1 {
    // 任意给定一个32位无符号整数n，求n的二进制表示中1的个数，比如n = 5（0101）时，返回2，n = 15（1111）时，返回4  
    //从{1, 2, 3, 4, 5, 3, 2, 4, 5}中找出单个的数字
    
    
    
     public int test(){
         int aa[] = {1,2,3,4,5,3,2,4,5};
//         int bb[] = aa.clone();
         int max = aa[0];
         for(int i =1; i <aa.length ;i++){
             if(max>aa[i]){
                 max = max;
             }else{
                 max = aa[i];
             }
             
         }
         System.out.println("最大的数："+max);
         return max;
     }
    
  
    public static void main(String agrs[]){
        
        int aaa = new Test1().test();
        System.out.println("---------------");
        int a = 8;
        int b = -8;
       // int c = ++a; //现加，再赋值给c
        int d = a++; // 先将a赋值给b,a再自加
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
       // System.out.println(c);
        System.out.println(d);
        System.out.println(a);
        
      //  boolean bb = a!=b;
        System.out.println("------华丽的分割线-1---");
        int e = 5 ;
        int f = -4;
       // int g = Integer.toBinaryString(e)&Integer.toBinaryString(f);
        System.out.println(Integer.toBinaryString(e));
        System.out.println(Integer.toBinaryString(f));
       // System.out.println(g);
        System.out.println(String.valueOf(Integer.toBinaryString(f)).length());  // 32位
        
        System.out.println("------华丽的分割线--2---");
        int g = 48;
        int h = g<<1; //左移运算符 -- 将 48 在内存中的二进制数据左移 1 位 。48的二进制数为 ：110000 ，左移1位 ，变为：1100000，移空的位置补 0
        System.out.println(Integer.toBinaryString(g));
        System.out.println(Integer.toBinaryString(96)); 
        System.out.println(h);
        
        System.out.println("------华丽的分割线--3---");
        int i = g>>3;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(g));
        System.out.println(Integer.toBinaryString(i));
        System.out.println("------华丽的分割线--4---");
        int k = -5;
        int l = k>>1;
        System.out.println(Integer.toBinaryString(k));
        System.out.println(Integer.toBinaryString(l));
        
        System.out.println("------华丽的分割线--5---");
        int m = 3<<2; // 3 * (2*2) = 12  //左移
        int n = 4<<3; // 4 * (2*2*2) = 32 //左移
        int o = 32>>2; // 32/(2*2) = 8 //右移
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
        
        System.out.println("------华丽的分割线--6---");
        System.out.println("绝对值:"+Math.abs(k));
        
        
       
        //异或 --- 相同为假 ，不同为真
        if((4^4) == 0){
            System.out.println("对还是cuo?");
            System.out.println("哈哈哈:"+(4^4));
            System.out.println("哈哈哈1:"+(4^2));
            System.out.println("哈哈哈:"+(5^1));
        }
        
        
    } 
    
}
