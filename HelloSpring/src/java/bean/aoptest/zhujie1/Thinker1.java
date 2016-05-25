/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest.zhujie1;

import bean.aoptest.*;

/**
 * 思索者(注解方式传递参数)
 *
 * @author Administrator
 */
public class Thinker1 implements ThinkerInterface1 {

    private String thoughts;

    public String getThoughts() {
        return thoughts;
    }

    //@Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }
}
