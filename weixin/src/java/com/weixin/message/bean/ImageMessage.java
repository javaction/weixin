/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 图片消息类
 * @author Administrator
 */
public class ImageMessage extends BaseMessage{
    
    private String PicUrl; //图片链接
    
    private String MediaId; //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

    /**
     * @return the PicUrl
     */
    public String getPicUrl() {
        return PicUrl;
    }

    /**
     * @param PicUrl the PicUrl to set
     */
    public void setPicUrl(String PicUrl) {
        this.PicUrl = PicUrl;
    }

    /**
     * @return the MediaId
     */
    public String getMediaId() {
        return MediaId;
    }

    /**
     * @param MediaId the MediaId to set
     */
    public void setMediaId(String MediaId) {
        this.MediaId = MediaId;
    }
    
    
    
    
}
