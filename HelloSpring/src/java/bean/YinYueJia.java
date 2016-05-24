/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Administrator
 */
public class YinYueJia {

    private String song; //歌曲
    private YueQi yueQi; //乐器

    public YinYueJia() {
    }
    
    public void perform(){
        System.out.println("演唱"+song+"开始。");
        yueQi.play();
    }
    

    public YueQi getYueQi() {
        return yueQi;
    }

    public void setYueQi(YueQi yueQi) {
        this.yueQi = yueQi;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
