/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 小视频消息类
 * @author Administrator
 */
public class ShortVideoMessage extends BaseMessage{
    
    private String MediaId; //视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    
    private String ThumbMediaId; //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

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

    /**
     * @return the ThumbMediaId
     */
    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    /**
     * @param ThumbMediaId the ThumbMediaId to set
     */
    public void setThumbMediaId(String ThumbMediaId) {
        this.ThumbMediaId = ThumbMediaId;
    }
    
    
    
    
    
    
    
}
