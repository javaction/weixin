/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 响应消息的基类
 * 消息基类（公众账号-->普通用户）
 * @author Administrator
 */
public class BaseMessage {
    
    private String ToUserName; //开发者微信号
    
    private String FromUserName; //发送方账号（一个openID）
    
    private long CreateTime; // 消息创建时间 （整型）
    
    private String MsgType; //消息类型
    
    private long MsgId;  //消息id，64位整型

    /**
     * @return the ToUserName
     */
    public String getToUserName() {
        return ToUserName;
    }

    /**
     * @param ToUserName the ToUserName to set
     */
    public void setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
    }

    /**
     * @return the FromUserName
     */
    public String getFromUserName() {
        return FromUserName;
    }

    /**
     * @param FromUserName the FromUserName to set
     */
    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }

    /**
     * @return the CreateTime
     */
    public long getCreateTime() {
        return CreateTime;
    }

    /**
     * @param CreateTime the CreateTime to set
     */
    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
    }

    /**
     * @return the MsgType
     */
    public String getMsgType() {
        return MsgType;
    }

    /**
     * @param MsgType the MsgType to set
     */
    public void setMsgType(String MsgType) {
        this.MsgType = MsgType;
    }

    /**
     * @return the MsgId
     */
    public long getMsgId() {
        return MsgId;
    }

    /**
     * @param MsgId the MsgId to set
     */
    public void setMsgId(long MsgId) {
        this.MsgId = MsgId;
    }

    
   
    
}
