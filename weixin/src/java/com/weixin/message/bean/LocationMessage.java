/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 地理位置消息类
 * @author Administrator
 */
public class LocationMessage extends BaseMessage{
    
    private String Location_X; //地理位置维度 
    
    private String Location_Y; //地理位置经度
    
    private String Scale; //地图缩放大小
    
    private String Label; //地理位置信息

    /**
     * @return the Location_X
     */
    public String getLocation_X() {
        return Location_X;
    }

    /**
     * @param Location_X the Location_X to set
     */
    public void setLocation_X(String Location_X) {
        this.Location_X = Location_X;
    }

    /**
     * @return the Location_Y
     */
    public String getLocation_Y() {
        return Location_Y;
    }

    /**
     * @param Location_Y the Location_Y to set
     */
    public void setLocation_Y(String Location_Y) {
        this.Location_Y = Location_Y;
    }

    /**
     * @return the Scale
     */
    public String getScale() {
        return Scale;
    }

    /**
     * @param Scale the Scale to set
     */
    public void setScale(String Scale) {
        this.Scale = Scale;
    }

    /**
     * @return the Label
     */
    public String getLabel() {
        return Label;
    }

    /**
     * @param Label the Label to set
     */
    public void setLabel(String Label) {
        this.Label = Label;
    }
    
    
    
    
    
}
