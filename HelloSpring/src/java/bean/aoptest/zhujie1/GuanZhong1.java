/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest.zhujie1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 观众类1，用于测试通过注解的方式来创建切面， 先前的测试中在切面类中没有任何配置，只是通过在xml文件中配置来实现
 *
 * @author Administrator
 */
@Aspect
public class GuanZhong1 {

    @Pointcut("execution(* bean.aoptest.zhujie1.YanYuan1.biaoyan1(..))")
    public void performance() {
        //定义切点，此方法可以是空的，目的是让@Pointcut注解依附
    }

    //  @Before("performance()")
    public void turnOffPhone1() {
        //表演开始前
        System.out.println("把手机也关掉.");
    }

    //  @Before("performance()")
    public void takeSeats1() {
        //表演开始前
        System.out.println("开始表演前，准备马扎..");
    }

    // @AfterReturning("performance()")
    public void applaud1() {
        //表演后，很好
        System.out.println("啪啪啪,使劲鼓掌...");
    }

    // @AfterThrowing("performance()")
    public void demandRefund1() {
        //表演后，不好
        System.out.println("表演的不好，还钱还钱..");
    }

    public void keng1() {
        System.out.println("观众1号说：“不管好不好，门票钱是不会退了，下次不来了。”");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //表演开始前1
            System.out.println("(环绕)开始表演前，准备马扎..");
            //表演开始前2
            System.out.println("(环绕)把手机也关掉.");
            long start = System.currentTimeMillis();

            joinPoint.proceed();//自己理解：这里使用的是在xml配置中传来的 切点 (biaoyan())
            long end = System.currentTimeMillis();

            System.out.println("(环绕)共表演了：" + (end - start) + "时间。");

        } catch (Exception e) {
            System.out.println("(环绕)表演的不好，还钱还钱..");
        } finally {
            System.out.println("(环绕)观众1号说：“不管好不好，门票钱是不会退了，下次不来了。”");
        }

    }
}
