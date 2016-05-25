/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weixin.util;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *  给别人写的exceldemo.没有测试
 * @author Administrator
 */
public class ExcelUtils {
    
    public void exportExcel(HttpServletResponse response){
        
        try {  
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("前台用户表数据");
            HSSFRow row  = sheet.createRow(0);

            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            String fileName = "前台用户数据.xls";
            this.setResponseHeader(response, fileName); 

//            HSSFCell cell = row.createCell(0);
//            cell.setCellValue("id");
//            cell.setCellStyle(style);
//
//            cell = row.createCell(1);
//            cell.setCellValue("登录名称");
//            cell.setCellStyle(style);
//
//            cell = row.createCell(2);
//            cell.setCellValue("企业名称(中文)");
//            cell.setCellStyle(style);
//
//            cell = row.createCell(3);
//            cell.setCellValue("企业名称(英文)");
//            cell.setCellStyle(style);
            
            //我在这里自定义一个表头,实际根据前端传来
            String titleTitle = "name,age,address,color";
            String[] strArray = titleTitle.split(",");  
           if(strArray!=null){
               int i = 0;
               for(String str : strArray){
                   HSSFCell cell = row.createCell(i);
                   cell.setCellValue(str);
                   cell.setCellStyle(style);
                   i++;
               }
           }
            

//            List<String> list = getList();
//            if(list !=null){
//                int j = 1;
//                row = sheet.createRow(j);  //创建一行
//                for(int i=0;i<list.size();i++){
//                   
//                    row.createCell(i).setCellValue(list.get(i));
//                    j++;
//                }
//            }
            
           //我在这里获取catList,并写入到excel中
           List<Cat> catList = this.setCatsList();
           if(catList!=null&&catList.size()>0){
               int m = 1;
               for(Cat cat :catList){
                   row = sheet.createRow(m); //创建行
                   int n = 0;
                   for(String str : strArray){
                       String cellVal = "";
                       if("name".equals(str)){
                           cellVal = cat.getName();
                       }
                       else if("age".equals(str)){
                           cellVal = cat.getAge();
                       }
                       else if("address".equals(str)){
                           cellVal = cat.getAddress();
                       }
                       else if("color".equals(str)){
                           cellVal = cat.getColor();
                       }
                       
                       row.createCell(n).setCellValue(cellVal);
//                       HSSFCell cell = row.createCell(n);
//                       cell.setCellValue(cellVal);
//                       cell.setCellStyle(style);
                       n++;
                   }
                   m++;
               }
               
           }
           
            OutputStream os = response.getOutputStream();  
            wb.write(os);  
            os.flush();  
            os.close();  
        } catch (Exception e) {  
             e.printStackTrace();  
        }  
		
	}

    /**
     * 我在这里定义了一个类，实际中的查询出来的数据，也是封装到一个自定义类中，而不是简单的一个String类
     */
    class Cat{
        private String name;
        private String age;
        private String address;
        private String color;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the age
         */
        public String getAge() {
            return age;
        }

        /**
         * @param age the age to set
         */
        public void setAge(String age) {
            this.age = age;
        }

        /**
         * @return the address
         */
        public String getAddress() {
            return address;
        }

        /**
         * @param address the address to set
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /**
         * @return the color
         */
        public String getColor() {
            return color;
        }

        /**
         * @param color the color to set
         */
        public void setColor(String color) {
            this.color = color;
        }
        
    }
    
    /**
     * 我在这里模拟放入一些数据，返回catList
     * @return 
     */
    public List<Cat> setCatsList(){
        
        List<Cat> catList = new ArrayList<Cat>();
        
        for(int i = 0 ; i<=4 ; i++){
            Cat cat = new Cat();
            cat.setName("小明"+i);
            cat.setAge("12岁"+i);
            cat.setColor("红色"+i);
            cat.setAddress("山东"+i);
            catList.add(cat);
        }
        
        return catList;
    }
    
    
    
    
	public List<String> getList(){
            List<String> list = new ArrayList<String>();
            list.add("001");
            list.add("caokangjing");
            list.add("中国汗能");
            list.add("hanneng");
            return list;
	}
	
	
	 public void setResponseHeader(HttpServletResponse response, String fileName) {  
         try {  
              try {  
                   fileName = new String(fileName.getBytes(),"ISO8859-1");  
              } catch (UnsupportedEncodingException e) {  
                   // TODO Auto-generated catch block  
                   e.printStackTrace();  
              }  
              response  
                        .setContentType("application/octet-stream;charset=ISO8859-1");  
              response.setHeader("Content-Disposition", "attachment;filename="  
                        + fileName);  
              response.addHeader("Pargam", "no-cache");  
              response.addHeader("Cache-Control", "no-cache");  
         } catch (Exception ex) {  
              ex.printStackTrace();  
         }  
    }  
    
         
         
         
         
    
}
