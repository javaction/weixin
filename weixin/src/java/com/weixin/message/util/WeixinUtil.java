/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.util;

import com.weixin.util.LogManager;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Administrator
 */
public class WeixinUtil {
    private static final Logger logger = LogManager.getLogger(WeixinUtil.class);
    
    /**
     * 
     * @param url
     * @return 
     */
    public static String getUrl(String url){
        String result = "";
        try {
            //根据地址获取请求
            HttpGet request = new HttpGet(url);
            //获取当前客户端对象
            HttpClient httpClient = new DefaultHttpClient();
            //通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(request);
            
            //判断网络连接状态是否正常（0--200都是正常的）
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //需要看下http协议----------暂记
                result = EntityUtils.toString(response.getEntity());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    //发起https请求并获取结果
    
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr){
        StringBuffer buffer = new StringBuffer();    
        try {
            ///加油啊
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
}
