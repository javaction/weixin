/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest.zhujie1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class Test1 {

    public static void main(String args[]) {

        ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/mytestgit/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");
        //ApplicationContext app = new ClassPathXmlApplicationContext("file:E:/MyGitHub/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");
        
        //1.使用注解的方式 创建切面 一般形式 与 环绕形式
//        YanYuan1 yy1 = app.getBean("yanyuan1", YanYuan1.class);
//        //自己测试的结果：同样是@Before注解的通知，先写的，后执行。如：准备马扎、关手机的例子
//        yy1.biaoyan1();
        
        //2.使用注解的方式给标注的通知传递参数
        Thinker1 thinker1 = app.getBean("thinker1", Thinker1.class);
        thinker1.thinkOfSomething("你想干吗？");
        
    }
}
