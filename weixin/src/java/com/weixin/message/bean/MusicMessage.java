/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

import com.weixin.message.bean.news.BaseMessage1;

/**
 * 音乐消息类
 * @author Administrator
 */
public class MusicMessage extends BaseMessage1{
    
    private Music Music;
 
    /**
     * @return the Music
     */
    public Music getMusic() {
        return Music;
    }

    /**
     * @param Music the Music to set
     */
    public void setMusic(Music Music) {
        this.Music = Music;
    }

   
    
}
