/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jqgrid.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
public class JqGridServlet002 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //  response.setContentType("application/json;charset=UTF-8");

        String str = this.readJSONString(request);
        //System.out.println("----" + str);
        //解析传来的json数据{id:4}
        
//        JSONArray jsonarray = JSONArray.fromObject("["+str+"]");
        JSONArray jsonarray = JSONArray.fromObject(str);
       // System.out.println(jsonarray);
        List list = (List)JSONArray.toCollection(jsonarray, Parameter.class);//person类
        Iterator ite = list.iterator();
        String id = null;
        while(ite.hasNext()){
            Parameter pp = (Parameter)ite.next();
           // System.out.println(pp.getIds());     
            id = pp.getIds();
        }     
        System.out.println("*/*/*/*/*/*/*"+id); 
        //根据id查找对应的student
        /////
        

    }

    /**
     * 以ajax形式提交到servlet中的post数据参数，可以用此方法获取
     *
     * @param request
     * @return
     */
    public String readJSONString(HttpServletRequest request) {
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }
}
