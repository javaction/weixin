/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 图文消息中Articles（list）中对象的定义
 * @author Administrator
 */
public class Item {
    
    private String Title; // 图文消息标题
    
    private String Description; //图文消息描述
    
    private String PicUrl; //图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200 
    
    private String Url; //点击图片消息跳转链接

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return null == Description ? "" : Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the PicUrl
     */
    public String getPicUrl() {
        return null == PicUrl ? "" : PicUrl;
    }

    /**
     * @param PicUrl the PicUrl to set
     */
    public void setPicUrl(String PicUrl) {
        this.PicUrl = PicUrl;
    }

    /**
     * @return the Url
     */
    public String getUrl() {
        return null == Url ? "" : Url;
    }

    /**
     * @param Url the Url to set
     */
    public void setUrl(String Url) {
        this.Url = Url;
    }
    
    
    
    
    
}
