/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 *
 * @author Administrator
 */
public class TestStudent {

    public static void main(String args[]) {

        //使用file前缀时，可以使用绝对路径 -- ok
        ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/mytestgit/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");
        //  ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/activeMQ/ssh2Demo/HelloSpring/web/WEB-INF/applicationContext.xml");
        //直接使用文件系统下的xml文件配置 -- ok
//        ApplicationContext app = new FileSystemXmlApplicationContext("D:/activeMQ/ssh2Demo/HelloSpring/web/WEB-INF/applicationContext.xml");

        //1.测试成功 -- ok
//        Student st = (Student)app.getBean("student");
//        st.sayHello();

        //2.测试成功 -- ok
//        WuTai wt =  app.getBean("wutai",WuTai.class);
//        wt.biaoyan();
//        ((ClassPathXmlApplicationContext)app).close(); //

        //3.
        YinYueJia yyj = app.getBean("yinyuejia", YinYueJia.class);
        yyj.perform();

        //4.
//         OnePersonBank o = app.getBean("onepersonbank", OnePersonBank.class);
//         o.performOnePerson();

    }
}
