/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * 用于测试Spring配置中的bean声明
 * @author Administrator
 */
public class Student {
    
    private String name ;
    private int age = 18;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }
    
    /**
     * 测试通过  构造器注入 
     */
    public void sayHello(){
        System.out.println("小明的年龄是："+age+"岁。");
    }
    

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
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    
}
