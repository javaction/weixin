/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 * 普通按钮（可能是二级菜单，也可能是不含二级菜单的一级菜单）
 * @author Administrator
 */
public class CommonButton extends Button{
    
    private String type;
    
    private String key;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
    
    
    
    
}
