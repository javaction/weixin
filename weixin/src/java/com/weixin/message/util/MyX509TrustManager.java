/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.util;

import com.weixin.util.LogManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Logger;
import javax.net.ssl.X509TrustManager;

/**
 * 证书信任管理器（用于https请求）
 * @author Administrator
 */
public class MyX509TrustManager implements X509TrustManager{
    private static final Logger logger = LogManager.getLogger(MyX509TrustManager.class);
    
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        logger.info("aaaaaaaaaa");
    }  
  
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
        logger.info("bbbbbbbbb");
    }  
  
    public X509Certificate[] getAcceptedIssuers() {  
        logger.info("ccccccccccc");// 先前，直接使用的ide提示，出了错，现在ok了
        return null;  
    }  
    
    
    
}
