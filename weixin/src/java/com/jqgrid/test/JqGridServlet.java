/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jqgrid.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class JqGridServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObj = new JSONObject();
        //根据jqGrid对于json数据的格式要求给jsonObject赋值
        jsonObj.put("page", 1); //当前页
        jsonObj.put("total", 1); //总页数
        jsonObj.put("records", 25); //总记录数
        //定义rows，存放数据
//        JSONArray rows = new JSONArray();
//
//        for (int i = 0; i <= 25; i++) {
//            JSONObject obj = new JSONObject();
//            obj.put("id", i + 1);
//            obj.put("name", "小明" + i);
//            obj.put("age", "12" + i);
//            obj.put("sex", "男或女");
//            obj.put("email", "123@123.com");
//            obj.put("school", "育才小学");
//            obj.put("phone", "123456");
//            obj.put("birthday", "2015-02-" + (i + 1));
//
//            rows.add(obj);
//        }
        JSONArray rows = new StudentService().studentArray();
        
        jsonObj.put("rows", rows);
      //  System.out.println("---" + jsonObj.toString());
        response.getWriter().print(jsonObj);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
