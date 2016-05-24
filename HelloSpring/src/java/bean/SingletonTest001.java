/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Administrator
 */
public class SingletonTest001 {

    private static SingletonTest001 singletonTest001;

    private SingletonTest001() {
    }

    private static SingletonTest001 getInstance() {

        if (singletonTest001 == null) {
            singletonTest001 = new SingletonTest001();
        }
        return singletonTest001;
    }
    /*
     * 如何将没有公开构造方法的 单例类 配置为一个Bean呢？
     * <bean> 有一个 factory-method的属性，允许我们调用一个指定的静态方法，
     * 从而代替构造方法来创建一个类的实例。在这里调用的就是  getInstance()这个方法。
     * 
     */
    
}
