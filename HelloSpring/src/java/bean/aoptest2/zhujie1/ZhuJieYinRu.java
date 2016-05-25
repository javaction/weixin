/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest2.zhujie1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 以 注解方式 引入
 * @author Administrator
 */
@Aspect
public class ZhuJieYinRu {
    /*
     * value ： 相当于 <aop:declare-parents> 中的 types-matching 属性，用于标识 应该被引入接口的Bean的类型，即：之前原始的类 
     * defaultImpl ：相当于 <aop:declare-parents> 中的 default-impl 属性，用于标识 新功能默认实现的类
     */
    @DeclareParents(value="bean.aoptest2.zhujie1.XiaoMing",defaultImpl=DoSomething.class)
    public  AddInterface addInterface;
}
