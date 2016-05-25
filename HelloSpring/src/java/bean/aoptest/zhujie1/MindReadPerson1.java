/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest.zhujie1;

import bean.aoptest.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 读心者（注解方式传递参数）
 *
 * @author Administrator
 */
@Aspect
public class MindReadPerson1 implements MindReaderInterface1 {

    private String thoughts;

    @Pointcut("execution(* bean.aoptest.zhujie1.Thinker1.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts) {
    }

    @Before("thinking(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("(注解)我开始读你心啦。你在想：" + thoughts);
        this.thoughts = thoughts;
    }

    public String getThoughts() {

        return thoughts;
    }
}
