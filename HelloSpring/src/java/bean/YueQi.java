/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Administrator
 */
public class YueQi {
    
    private String yuQiName; //乐器名称 
    
    
    public void play(){
        
        System.out.println("用乐器（"+yuQiName+"）演奏，开始。");
    }

    public String getYuQiName() {
        return yuQiName;
    }

    public void setYuQiName(String yuQiName) {
        this.yuQiName = yuQiName;
    }
    
}
