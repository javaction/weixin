/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 *  语音消息类
 * @author Administrator
 */
public class VoiceMessage extends BaseMessage{
    
    private String MediaId; //语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    
    private String Format;// 语音格式，如amr，speex等
    
 //   private String Recognition; //语音识别结果
    
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
     * @return the Format
     */
    public String getFormat() {
        return Format;
    }

    /**
     * @param Format the Format to set
     */
    public void setFormat(String Format) {
        this.Format = Format;
    }
    
    
    
}
