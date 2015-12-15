/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * AccessToken类
 * @author Administrator
 */
public class AccessToken {
    
    private String access_token; //  	获取到的凭证 
    
    private long expires_in; //凭证有效时间，单位：秒 

    /**
     * @return the access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     * @param access_token the access_token to set
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     * @return the expires_in
     */
    public long getExpires_in() {
        return expires_in;
    }

    /**
     * @param expires_in the expires_in to set
     */
    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
    
    
}
