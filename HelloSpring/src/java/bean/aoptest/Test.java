/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String args[]) {

        //ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/activeMQ/ssh2Demo/HelloSpring/web/WEB-INF/applicationContext.xml");
        ApplicationContext app = new ClassPathXmlApplicationContext("file:E:/MyGitHub/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");
        //1.
//        YanYuan yanyuan = app.getBean("yanyuan", YanYuan.class);
//        yanyuan.biaoyan();
//        System.out.println("------------华丽的分割线------------");

        //2.为通知传递参数
        Thinker thinker = app.getBean("thinker", Thinker.class);
        thinker.thinkOfSomething("你好，world");

    }
}
