/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class Test2 {

    public static void main(String args[]) {

        ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/activeMQ/ssh2Demo/HelloSpring/web/WEB-INF/applicationContext.xml");
        //1.xiaoming的原始方法，测试ok
        XiaoMing xm = app.getBean("xiaoming", XiaoMing.class);
        xm.say();

        //2.利用切面 给xiaoming增加了新的方法，测试ok
        AddInterface xm3 = app.getBean("xiaoming", AddInterface.class);
        xm3.toDo();

        //3. ☆☆☆☆☆☆☆☆☆☆☆☆☆☆--------- 这种方式是不对的
//        DoSomething xm2 = app.getBean("xiaoming", DoSomething.class);
//        xm2.toDo();


    }
}
