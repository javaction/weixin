/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.bean;

/**
 *
 * @author Administrator
 */
public class ComplexButton extends Button{
    
    
    private Button[] sub_button;

    /**
     * @return the sub_button
     */
    public Button[] getSub_button() {
        return sub_button;
    }

    /**
     * @param sub_button the sub_button to set
     */
    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
    
    
}
