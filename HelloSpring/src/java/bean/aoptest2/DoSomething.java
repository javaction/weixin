/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest2;

/**
 *
 * @author Administrator
 */
public class DoSomething implements AddInterface{

    @Override
    public void toDo() {
        System.out.println("还要做些其他的事情..");
    }
    
}
