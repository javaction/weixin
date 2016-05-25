/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest.zhujie1;

import bean.aoptest.*;

/**
 * 读心者接口(注解）
 * @author Administrator
 */
public interface MindReaderInterface1 {

    public void interceptThoughts(String thoughts);//拦截想法

    public String getThoughts();
}
