/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest2.zhujie1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试基于注解形式，给某个Bean增加新的功能
 *
 * @author Administrator
 */
public class Test1 {

    public static void main(String args[]) {

        ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/mytestgit/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");
        //ApplicationContext app = new ClassPathXmlApplicationContext("file:E:/MyGitHub/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");
   
        //1.
        XiaoMing xiaoMing = app.getBean("xiaoMing", XiaoMing.class);
        xiaoMing.say();
       
        //2.通过 注解形式 可以增加新的功能
        AddInterface xm = app.getBean("xiaoMing", AddInterface.class);
        xm.toDo();
        

    }
}
