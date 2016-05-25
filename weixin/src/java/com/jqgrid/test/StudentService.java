/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jqgrid.test;

import java.util.ArrayList;
import java.util.List;
import javax.sql.RowSet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class StudentService {

    /**
     * 模拟生成一些数据1
     *
     * @return
     */
    public List<Student> findAll() {
        List<Student> studentLsit = new ArrayList<Student>();
        Student student = null;
        for (int i = 1; i <= 25; i++) {
            student = new Student();
            student.setId(i);
            if (i % 2 == 0) {
                student.setName("小明" + i);
                student.setSex("男");
            } else {
                student.setName("小红" + i);
                student.setSex("女");
            }
            student.setAge("18");
            student.setEmail("123@123.com");
            student.setPhone("123456789");
            student.setBirthday("2015-02-" + (i + 1));
            studentLsit.add(student);
        }

        return studentLsit;
    }

    /**
     * 模拟生成数据2
     *
     * @return
     */
    public JSONArray studentArray() {
        JSONArray rows = new JSONArray();

        for (int i = 0; i <= 25; i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", i + 1);

            if (i % 2 == 0) {
                obj.put("name", "小明" + i);
                obj.put("sex", "男");
            } else {
                obj.put("name", "小红" + i);
                obj.put("sex", "女");
            }
            obj.put("age", "18");
            obj.put("email", "123@123.com");
            obj.put("school", "育才小学");
            obj.put("phone", "123456");
            obj.put("birthday", "2015-02-" + (i + 1));

            rows.add(obj);
        }
        return rows;
    }
}
