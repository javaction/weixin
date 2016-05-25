/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

/**
 *
 * @author Administrator
 */
public class TestTab {

    //测试tab键分割的情况
    public void testTab() {
        String a = "1-1-402";
        String b = "21502036";
        String c = "109739";
        String d = "0000";
        String e = "夏逸花园-01-1-0402";
        String f = "0";
        String g = "0";

        String str = a + "\t" + b + "\t" + c + "\t" + d + "\t" + e + "\t" + f + "\t" + g;
        System.out.println(str);

        String[] arr = str.split("\t");
        System.out.println("数组大小：" + arr.length);

        for (int i = 0; i < arr.length; i++) {

            System.out.println("分割后的：" + arr[i]);

        }



    }

    public static void main(String args[]) {
        TestTab t = new TestTab();

        t.testTab();

    }
}
