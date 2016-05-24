/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.autobean;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 */
public class Counter {

    private int multiplier;
    private String song;
    @Resource
    private Instrument instrument;

    public Counter(int multiplier, String song, Instrument instrument) {
        this.multiplier = multiplier;
        this.song = song;
        this.instrument = instrument;
    }

    /**
     * @return the song
     */
    public String getSong() {
        return song;
    }

    /**
     * @param song the song to set
     */
    public void setSong(String song) {
        this.song = song;
    }

    /**
     * @return the instrument
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * @param instrument the instrument to set
     */
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    /**
     * @return the multiplier
     */
    public int getMultiplier() {
        return multiplier;
    }

    /**
     * @param multiplier the multiplier to set
     */
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
