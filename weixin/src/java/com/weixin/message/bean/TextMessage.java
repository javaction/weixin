/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 文本消息类
 * @author Administrator
 */
public class TextMessage extends BaseMessage{
        
    private String Content; //文本消息内容

    /**
     * @return the Content
     */
    public String getContent() {
        return Content;
    }

    /**
     * @param Content the Content to set
     */
    public void setContent(String Content) {
        this.Content = Content;
    }
    
    
    
}
