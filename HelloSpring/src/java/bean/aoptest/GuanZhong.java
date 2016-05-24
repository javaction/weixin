/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 观众，用于测试切面配置和使用
 *
 * @author Administrator
 */
public class GuanZhong {

    //////这些方法都是通知方法。通知只是定义了是什么和何时。
    public void takeSeats() {
        //表演开始前
        System.out.println("开始表演前，准备马扎..");
    }

    public void turnOffPhone() {
        //表演开始前
        System.out.println("把手机也关掉.");
    }

    public void applaud() {
        //表演后，很好
        System.out.println("啪啪啪,使劲鼓掌...");
    }

    public void demandRefund() {
        //表演后，不好
        System.out.println("表演的不好，还钱还钱..");
    }

    public void keng() {
        System.out.println("观众1号说：“不管好不好，门票钱是不会退了，下次不来了。”");
    }

    ////用来测试环绕通知，在这个方法中，先前的几个方法的逻辑都已经包含在其中，使用的是 ProceedingJoinPoint
    public void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //表演开始前1
            System.out.println("开始表演前，准备马扎..");
            //表演开始前2
            System.out.println("把手机也关掉.");
            long start = System.currentTimeMillis();

            joinPoint.proceed();//自己理解：这里使用的是在xml配置中传来的 切点 (biaoyan())
            long end = System.currentTimeMillis();

            System.out.println("共表演了：" + (end - start) + "时间。");

        } catch (Exception e) {
            System.out.println("表演的不好，还钱还钱..");
        } finally {
            System.out.println("观众1号说：“不管好不好，门票钱是不会退了，下次不来了。”");
        }

    }
    
    
    
    
    
}
