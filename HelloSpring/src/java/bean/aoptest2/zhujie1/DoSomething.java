/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest2.zhujie1;

import bean.aoptest2.*;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author Administrator
 */
@Aspect
public class DoSomething implements AddInterface {

//    @Override
    public void toDo() {
        System.out.println("（注解形式）还要做些其他的事情..");
    }
}
