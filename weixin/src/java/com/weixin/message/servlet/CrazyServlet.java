/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.message.servlet;

import com.weixin.message.util.SignUtil;
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
        processRequest(request, response);
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
