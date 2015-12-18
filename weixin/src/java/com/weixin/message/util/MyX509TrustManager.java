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
    
    @Override
    public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        throw new UnsupportedOperationException("Not supported yet11111.");       
    }

    @Override
    public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        throw new UnsupportedOperationException("Not supported yet22222.");
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        throw new UnsupportedOperationException("Not supported yet33333.");
    }
    
    
    
}
