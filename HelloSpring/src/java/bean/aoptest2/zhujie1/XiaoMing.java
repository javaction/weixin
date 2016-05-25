/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest2.zhujie1;

import bean.aoptest2.*;
import org.aspectj.lang.annotation.DeclareParents;

/**
 *
 * @author Administrator
 */
public class XiaoMing implements ChineseInterface {
    
    public void say() {
        System.out.println("（注解形式）小明说中国话");
    }
}
