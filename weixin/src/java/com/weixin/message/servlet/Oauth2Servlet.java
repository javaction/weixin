/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.servlet;

import com.weixin.message.util.HttpUtil;
import com.weixin.util.LogManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 * 
 * @author Administrator
 */
public class Oauth2Servlet extends HttpServlet {
    
    private static final Logger logger = LogManager.getLogger(Oauth2Servlet.class);
    
    //获取code后，请求以下链接获取access_token
    public static String getAccessTokenUrl =     
            "https://api.weixin.qq.com/sns/oauth2/access_token?" +
            "appid=APPID" +
            "&secret=SECRET&" +
            "code=CODE&grant_type=authorization_code";
            //"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";    
            
    //获取用户信息（这个获取，后期可以改成一个util，与获取access_token一样，都单独拆成一个util）
    public static String getUserInfo = 
            "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    
    //备注：正常的话，还有许多的url可以使用，来此来获取对应的数据，相减开发文档提供的url以及返回数据示例
    
    //开发者自己的测试号 APPID APPSECRET //暂时写在这里，后期与上一起整合
    public static final String appId = "wx9bcaad2fea836e55";
    public static final String appSecret = "31a376dfc86d858d02eb14514ab96bf5";
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Oauth2Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Oauth2Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //将请求和响应的编码都设置成utf-8,放置中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //code 从请求中获取 //（用户授权并获取code这步，对应⑥）
        String code = request.getParameter("code");
        
        getAccessTokenUrl = getAccessTokenUrl.replace("APPID", appId);
        getAccessTokenUrl = getAccessTokenUrl.replace("SECRET", appSecret);
        getAccessTokenUrl = getAccessTokenUrl.replace("CODE", code);
        
        String json = HttpUtil.getUrl(getAccessTokenUrl);
        
        JSONObject jsonObject = JSONObject.fromObject(json);
        String accessToken = jsonObject.getString("access_token");
        String openId = jsonObject.getString("openid");
        
        logger.info("----accessToken---:"+accessToken);
        logger.info("----openId---:"+openId);
        
        getUserInfo = getUserInfo.replace("ACCESS_TOKEN", accessToken);
        getUserInfo = getUserInfo.replace("OPENID", openId);
        
        String userInfoJsonStr = HttpUtil.getUrl(getUserInfo);
        JSONObject userInfoJson = JSONObject.fromObject(userInfoJsonStr);
        
        String user_openid = userInfoJson.getString("openid");
        String user_nickname = userInfoJson.getString("nickname");
        String user_sex = userInfoJson.getString("sex");
        String user_province = userInfoJson.getString("province");
        String user_city = userInfoJson.getString("city");
        String user_country = userInfoJson.getString("country");
        String user_headimgurl = userInfoJson.getString("headimgurl");
        
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method \n");
        out.println("openid:"+user_openid+"\n\n");        
        out.println("nickname:"+user_nickname+"\n\n");        
        out.println("sex:"+user_sex+"\n\n");        
        out.println("province:"+user_province+"\n\n");        
        out.println("city:"+user_city+"\n\n");        
        out.println("country:"+user_country+"\n\n");
        out.println("<img src=/"+user_headimgurl+"/");
        out.println(">");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
