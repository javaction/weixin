/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.service;

import com.weixin.message.bean.Music;
import com.weixin.util.LogManager;
import java.util.logging.Logger;

/**
 * 调用网易音乐api接口，实现回复音乐消息
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
        //String requestUrl = "http://music.163.com/api/search/pc%E5%85%84%E5%A6%B9&offset=1&limit=20&type=1";
        
        
    
        return null;
    }
    
    
    //test
    public static void main(String agrString[]){
        
        System.out.println("---encodeByUtf8()测试---："+encodeByUtf8("陈奕迅"));
    
    }
    
}
