/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.atutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 用于测试spring注解
 * @author Administrator
 */
public class Boss {
    
    private String bossName; 
    
    @Autowired(required=true)
//    @Qualifier(value="")  ///更精确的匹配，避免 @Autowired 造成的多个匹配bean
    private Car car;
    
    @Autowired
    private Office office ;
    
    public void peiZhi(){
        System.out.println("boss姓名："+bossName+"，开的车："+car.getCarName()+"，办公室号："+office.getOfficeNum());
        
    }
    
//    /**
//     * @return the car
//     */
//    public Car getCar() {
//        return car;
//    }
//
//    /**
//     * @param car the car to set
//     */
////    @Autowired
//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    /**
//     * @return the office
//     */
//    public Office getOffice() {
//        return office;
//    }
//
//    /**
//     * @param office the office to set
//     */
////    @Autowired
//    public void setOffice(Office office) {
//        this.office = office;
//    }
//
//    /**
//     * @return the bossName
//     */
//    public String getBossName() {
//        return bossName;
//    }
//
//    /**
//     * @param bossName the bossName to set
//     */
//    public void setBossName(String bossName) {
//        this.bossName = bossName;
//    }
    
    
}
