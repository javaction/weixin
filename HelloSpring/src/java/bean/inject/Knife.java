/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.inject;

/**
 * 用于测试 @Inject 注解
 * @author Administrator
 */
public class Knife {
    
    private  String knifeName ;

    /**
     * @return the knifeName
     */
    public String getKnifeName() {
        return knifeName;
    }

    /**
     * @param knifeName the knifeName to set
     */
    public void setKnifeName(String knifeName) {
        this.knifeName = knifeName;
    }
    
}
