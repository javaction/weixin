/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *
 * @author Administrator
 */
public class NewInterceptor001 implements Interceptor {

    public NewInterceptor001() {
    }

    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /////////////////////////////////////////////////////////===分割线---此处与以上的都无关 ===////////////////////////////////
    
    /** 
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操 
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像， 
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor 
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。 
     */  
//    @Override  
//    public void postHandle(HttpServletRequest request,  
//            HttpServletResponse response, Object handler,  
//            ModelAndView modelAndView) throws Exception {  
//        // TODO Auto-generated method stub  
//          
//    } 
    
}
