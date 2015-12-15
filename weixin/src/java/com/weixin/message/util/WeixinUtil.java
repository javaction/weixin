/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.util;

import com.weixin.message.bean.AccessToken;
import com.weixin.util.LogManager;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 * 微信工具类，包括获取access_token，ect..
 * @author Administrator
 */
public class WeixinUtil {
    private static final Logger logger = LogManager.getLogger(WeixinUtil.class);
    
    //获取access_token的url
    public static String get_access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    
    
    /**
     * 获取access_token // getUrl
     * @param appid
     * @param secret
     * @return 
     */
    public static AccessToken getAccessToken(String appid, String secret){
        logger.info("----WeixinUtil.getAccessToken()----");
        AccessToken accessToken = null;
        
        try {
            String requestUrl = get_access_token_url.replace("APPID", appid).replace("APPSECRET", secret);
            
            String accessTokenJsonStr = HttpUtil.getUrl(requestUrl);
            JSONObject jsonObject = JSONObject.fromObject(accessTokenJsonStr);
            if(null != jsonObject){
                accessToken = new AccessToken();
                accessToken.setAccess_token(jsonObject.getString("access_token"));
                accessToken.setExpires_in(Long.valueOf(jsonObject.getString("expires_in")));               
            }
            
        } catch (Exception e) {           
            e.printStackTrace();
            logger.info("获取token失败 errcode:{} errmsg:{}");
        }
        return accessToken;
    }
    
    /**
     * 获取access_token  // httpRequest
     * @param appid
     * @param secret
     * @return 
     */
    public static AccessToken getAccessToken1(String appid, String secret){
        logger.info("----WeixinUtil.getAccessToken1()----");
        AccessToken accessToken = null;
        
        try {
            String requestUrl = get_access_token_url.replace("APPID", appid).replace("APPSECRET", secret);
            
            String accessTokenJsonStr = HttpUtil.httpRequest(requestUrl,"GET", null);
            JSONObject jsonObject = JSONObject.fromObject(accessTokenJsonStr);
            if(null != jsonObject){
                accessToken = new AccessToken();
                accessToken.setAccess_token(jsonObject.getString("access_token"));
                accessToken.setExpires_in(Long.valueOf(jsonObject.getString("expires_in")));               
            }
            
        } catch (Exception e) {           
            e.printStackTrace();
            logger.info("获取token失败 errcode:{} errmsg:{}");
        }
        return accessToken;
    }
    

    
//    public static void main(String ageString[]){
//        String appid = "wxd68a456655aa5fd9";
//        String secret = "d4624c36b6795d1d99dcf0547af5443d";
//        
//        AccessToken accessToken = WeixinUtil.getAccessToken1(appid, secret);
//        
//        System.out.println("-----access_token:"+accessToken.getAccess_token());
//        System.out.println("-----expires_in:"+accessToken.getExpires_in());
//
//        
//    }
    
    
    
}
