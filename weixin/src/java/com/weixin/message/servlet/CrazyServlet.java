/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.servlet;

import com.weixin.message.bean.AccessToken;
import com.weixin.message.util.SignUtil;
import com.weixin.message.util.WeixinUtil;
import com.weixin.service.CrazyService;
import com.weixin.service.MenuService;
import com.weixin.util.LogManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 核心请求处理类
 * @author Administrator
 */
public class CrazyServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CrazyServlet.class);
    private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrazyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrazyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        //微信加密签名
        String signature = request.getParameter("signature");
        //获取时间戳
        String timestamp = request.getParameter("timestamp");
        //获取随机数
        String nonce = request.getParameter("nonce");
        //获取随机字符串
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        
        
//        System.out.println("-111111---signature:"+signature);
//        System.out.println("--22222--timestamp:"+timestamp);
//        System.out.println("--33333--nonce:"+nonce);
       
        //通过检验signature对请求进行校验，若校验成功则原样返回echostr，标识接入成功，否则接入失败
        if(SignUtil.checkSignature(signature, timestamp, nonce)){
            System.out.println("----echostr:"+echostr);
            out.print(echostr);
        }    
        out.close();
        out = null;
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 将请求、响应的编码均设置成utf-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //调用核心业务类接收、处理消息
        String respMessage = CrazyService.processRequest(request);
        
        //响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
        
             
//        //获取access_token //测试ok //使用 httpRequest 则不可以。始终报自定义类（MyX509TrustManager）的错误。
//        String appid = "wxd68a456655aa5fd9";
//        String secret = "d4624c36b6795d1d99dcf0547af5443d";
//       // AccessToken accessToken = WeixinUtil.getAccessToken(appid, secret); 
//        AccessToken accessToken = WeixinUtil.getAccessToken(appid, secret);
//      //  AccessToken accessToken = WeixinUtil.getAccessToken1(appid, secret);//这种写法不对。
//        //本来是想创建自定义菜单，但是写在这里，不对。
//        int i = WeixinUtil.createMenu(MenuService.getMenu(), accessToken.getAccess_token());
        
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
