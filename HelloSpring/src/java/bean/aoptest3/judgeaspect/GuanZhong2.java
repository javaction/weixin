/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest3.judgeaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 本来是想测p107中的注入 AspectJ 切面。暂时放一放，，。。这个后面再测
 * @author Administrator
 */
public class GuanZhong2 {

    @Pointcut("execution(* bean.aoptest3.judgeaspect.biaoyan1(..))")
    public void performance() {
    }
    
    @Before("performance()")
    public void turnOffPhone1() {
        //表演开始前
        System.out.println("（注入AspectJ）把手机也关掉.");
    }
    @Before("performance()")
    public void takeSeats1() {
        //表演开始前
        System.out.println("（注入AspectJ）开始表演前，准备马扎..");
    }
    
    @AfterReturning("performance()")
    public void applaud1() {
        //表演后，很好
        System.out.println("（注入AspectJ）啪啪啪,使劲鼓掌...");
    }
    
    @AfterThrowing("performance()")
    public void demandRefund1() {
        //表演后，不好
        System.out.println("（注入AspectJ）表演的不好，还钱还钱..");
    }
    
    
    public void keng1() {
        System.out.println("（注入AspectJ）观众1号说：“不管好不好，门票钱是不会退了，下次不来了。”");
    }

    //@Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //表演开始前1
            System.out.println("（注入AspectJ）(环绕)开始表演前，准备马扎..");
            //表演开始前2
            System.out.println("（注入AspectJ）(环绕)把手机也关掉.");
            long start = System.currentTimeMillis();

            joinPoint.proceed();//自己理解：这里使用的是在xml配置中传来的 切点 (biaoyan())
            long end = System.currentTimeMillis();

            System.out.println("（注入AspectJ）(环绕)共表演了：" + (end - start) + "时间。");

        } catch (Exception e) {
            System.out.println("（注入AspectJ）(环绕)表演的不好，还钱还钱..");
        } finally {
            System.out.println("（注入AspectJ）(环绕)观众1号说：“不管好不好，门票钱是不会退了，下次不来了。”");
        }

    }
}
