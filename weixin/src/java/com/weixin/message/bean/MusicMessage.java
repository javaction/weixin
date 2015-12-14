/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 音乐消息类
 * @author Administrator
 */
public class MusicMessage extends BaseMessage{
    
    private Music music;

    /**
     * @return the music
     */
    public Music getMusic() {
        return music;
    }

    /**
     * @param music the music to set
     */
    public void setMusic(Music music) {
        this.music = music;
    }
    
    
    
}
