/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.autobean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String args[]) {

//        ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/activeMQ/ssh2Demo/HelloSpring/web/WEB-INF/applicationContext.xml");
//        ApplicationContext app = new FileSystemXmlApplicationContext("D:/activeMQ/ssh2Demo/HelloSpring/web/WEB-INF/applicationContext.xml");

        ApplicationContext app = new ClassPathXmlApplicationContext("file:E:/MyGitHub/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");

        Counter c = app.getBean("counter", Counter.class);
        System.out.println("=====" + c.getSong());

        System.out.println("=====" + c.getMultiplier());


    }
}
