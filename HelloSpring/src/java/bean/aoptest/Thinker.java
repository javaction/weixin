/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.aoptest;

/**
 * 思索着
 *
 * @author Administrator
 */
public class Thinker implements ThinkerInterface {

    private String thoughts;

    public String getThoughts() {
        return thoughts;
    }

    //@Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }
}
