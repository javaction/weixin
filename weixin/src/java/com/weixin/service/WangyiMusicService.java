/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.service;

import com.weixin.message.bean.Music;
import com.weixin.util.LogManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * 调用网易音乐api接口，实现回复音乐消息
 * 
 * 20160106，本想实现调用网易音乐的api接口，暂时没有实现。
 * 
 * @author Administrator
 */
public class WangyiMusicService {
    private static final Logger logger = LogManager.getLogger(WangyiMusicService.class);
    
    /**
     * 将某些字符串转换成utf8编码形式
     * @param resource
     * @return 
     */
    public static String encodeByUtf8(String resource){
        String result = resource;
        try {
            result = java.net.URLEncoder.encode(result, "utf-8");
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("[encodeByUtf8 Exception]"+e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 通过歌曲名称搜索music
     * @param songName
     * @return 
     */
    public static Music searchMusicFromWangyi(String songName){
        logger.info("-----searchMusicFromWangyi()-----");
        //网易的是使用的是post的形式..
        //String requestUrl = "http://music.163.com/api/search/pc?s=%E5%85%84%E5%A6%B9&offset=1&limit=20&type=1";
        
        
        
        return null;
    }
    
    /**
     * 根据请求url，发送http请求，并返回
     * @param requestUrl
     * @return 
     */
    public static InputStream httpRequestForWangi(String requestUrl,String jsonData){
        logger.info("----httpRequestForWangi-----");
       // InputStream inputStream = null; 
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false); //post请求不能使用缓存
            
            httpURLConnection.setInstanceFollowRedirects(true);
            
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            
            String input = jsonData;
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String lineString;
            String response = null;
            while((lineString = reader.readLine())!=null){
                System.out.println(lineString);
                response = lineString;
            }
            reader.close();
            httpURLConnection.disconnect();
            
//        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//        connection.connect();
//        DataOutputStream out = new DataOutputStream(connection
//                .getOutputStream());
//        String content = "account=" + URLEncoder.encode("一个大肥人", "UTF-8");
//        content +="&pswd="+URLEncoder.encode("两个个大肥人", "UTF-8");;
//        out.writeBytes(content);
//
//        out.flush();
//        out.close();
//       
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String line;     
//        while ((line = reader.readLine()) != null){
//            System.out.println(line);
//        }
//     
//        reader.close();
//        connection.disconnect();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
        return null; 
    } 
    
    
    
    //test
    public static void main(String agrString[]){
        
        System.out.println("---encodeByUtf8()测试---："+encodeByUtf8("陈奕迅"));
    
    }
    
}
