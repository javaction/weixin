/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.autobean;

/**
 *
 * @author Administrator
 */
public class Pinao extends Instrument{

    private String pinaoName = "钢琴一号";
    private String sound;

    /**
     * @return the pinaoName
     */
    public String getPinaoName() {
        return pinaoName;
    }

    /**
     * @param pinaoName the pinaoName to set
     */
    public void setPinaoName(String pinaoName) {
        this.pinaoName = pinaoName;
    }

    /**
     * @return the sound
     */
    public String getSound() {
        return sound;
    }

    /**
     * @param sound the sound to set
     */
    public void setSound(String sound) {
        this.sound = sound;
    }
}
