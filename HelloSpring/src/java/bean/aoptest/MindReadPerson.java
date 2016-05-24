/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest;

/**
 * 读心者
 *
 * @author Administrator
 */
public class MindReadPerson implements MindReaderInterface {

    private String thoughts;

    //@Override
    public void interceptThoughts(String thoughts) {
        System.out.println("我开始读你心啦。你在想："+thoughts);
        this.thoughts = thoughts;
    }

  //  @Override
    public String getThoughts() {

        return thoughts;
    }
}
