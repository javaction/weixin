/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class OnePersonBank {
    
    //private YueQi yueQi;

    public OnePersonBank() {
    }
    
    public void performOnePerson(){
        for(YueQi yueQi:yueQiList){
            yueQi.play();
        }
    
    }
    
    
    private List<YueQi> yueQiList;
    
    
    

    public List<YueQi> getYueQiList() {
        return yueQiList;
    }

    public void setYueQiList(List<YueQi> yueQiList) {
        this.yueQiList = yueQiList;
    }
    
    
    
}
