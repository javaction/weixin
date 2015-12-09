/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.util;
import com.weixin.util.LogManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * 请求校验工具类
 * @author Administrator
 */
public class SignUtil {
    private static final Logger logger = LogManager.getLogger(SignUtil.class);
    //接口被指信息的token ，这里要与其一致
    private static String token = "hellozhengze";
    
    /**
     * 验证签名信息
     * @param signature //微信加密签名
     * @param timestamp //时间戳
     * @param nonce //随机数
     * @return 
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce){
        logger.info("---checkSignature---");
        String strArray[] = new String[]{token,timestamp,nonce}; 
        //1.将 token,timestamp,nonce 三个参数进行字典序排序
        //Arrays.sort(strArray); //一种方式。也可以采用另一种，效果应该是一样的
        arraySort(strArray);
        StringBuilder content = new StringBuilder();        
        for(int i =0; i < strArray.length; i++){
            content.append(strArray[i]);
        }
        
        MessageDigest md = null;
        String tmpString = null;
        
        try { 
            md = MessageDigest.getInstance("SHA-1");
            // 2.将三个参数拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            logger.info("---digest[]--"+digest.length);
            //将字节数组转换成十六进制的字符串
            tmpString = byteToStr(digest);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        
        //3.开发者获得加密后的字符串与signature对比，标识该请求来源于微信
        logger.info(tmpString+"--------------"+signature.toLowerCase());
        return tmpString != null ? tmpString.equals(signature.toUpperCase()) : false;
    }
    
    /**
     * 将字节数组转换成十六进制字符串
     * @param byteArray
     * @return 
     */
    public static String byteToStr(byte[] byteArray){
        String str = "";
        for(int i =0; i<byteArray.length; i++){
           // str = str + byteToHexStr(byteArray[i]);
            str += byteToHexStr(byteArray[i]);// 也可以这样子写
        }
        
        return str;
    }
    
    /**
     * 将字节转换成十六进制字符串
     * @param mByte
     * @return 
     */
    public static String byteToHexStr(byte mByte){
        char digit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A','B', 'C', 'D', 'E', 'F'}; 
        char tempArr[] = new char[2];
        tempArr[0] = digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = digit[mByte & 0X0F];
        
        String str = new String(tempArr);
        return str;
    }
    
    
    public static void arraySort(String str[]){
        for(int i=0; i<str.length - 1; i++){
            for(int j = i+1; j<str.length;j++){
                if(str[j].compareTo(str[i])<0){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
    }
    
    
    
}
