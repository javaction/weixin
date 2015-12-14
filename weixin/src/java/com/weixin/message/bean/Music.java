/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 音乐消息中music类
 * @author Administrator
 */
public class Music {
    
    private String Title; //音乐标题
    
    private String Description; //音乐描述
    
    private String MusicURL; //音乐链接
    
    private String HQMusicUrl; //高质量音乐链接，WIFI环境优先使用该链接
    
    private String ThumbMediaId; //缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id 

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
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the MusicURL
     */
    public String getMusicURL() {
        return MusicURL;
    }

    /**
     * @param MusicURL the MusicURL to set
     */
    public void setMusicURL(String MusicURL) {
        this.MusicURL = MusicURL;
    }

    /**
     * @return the HQMusicUrl
     */
    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    /**
     * @param HQMusicUrl the HQMusicUrl to set
     */
    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
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
