/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author Administrator
 */
public class WuTai {
    
    public void biaoyan(){
        System.out.println("开始表演。。。");
    }

    public void kaideng() {
        System.out.println("开始表演前，开灯光。");
    }

    public void guandeng() {
        System.out.println("结束表演，关灯光。");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
}
