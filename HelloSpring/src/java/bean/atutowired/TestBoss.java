/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.atutowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class TestBoss {

    public String getDataByMillis(long millis) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return formatter.format(calendar.getTime());
    }

    public static void main(String args[]) {

//        TestBoss tb = new TestBoss();
//        long time = System.currentTimeMillis();
//        System.out.println("---"+time);
//        tb.getDataByMillis(time);
//        System.out.println("===="+tb.getDataByMillis(time));


//        ApplicationContext app = new ClassPathXmlApplicationContext("file:D:/activeMQ/ssh2Demo/HelloSpring/web/WEB-INF/applicationContext.xml");
        ApplicationContext app = new ClassPathXmlApplicationContext("file:E:/MyGitHub/weixin/HelloSpring/web/WEB-INF/applicationContext.xml");
        //1.测试传统xml配置 -- ok
//        Boss boss = app.getBean("boss", Boss.class);
//        boss.peiZhi();

        //2.
        Boss boss = app.getBean("boss", Boss.class);
        boss.peiZhi();


    }
}
