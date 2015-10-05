package com.example.michaelxi.reactiontimer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by michaelximac on 2015-10-04.
 */
public class Record {
    ArrayList <Long> single= new ArrayList<Long>();
    ArrayList<Integer> TwoPlayer= new ArrayList<>(Arrays.asList(0, 0));
    ArrayList<Integer> ThreePlayer= new ArrayList<>(Arrays.asList(0, 0, 0));
    ArrayList<Integer> FourPlayer= new ArrayList<>(Arrays.asList(0, 0, 0, 0));

    public ArrayList<Long> getSingle() {
        return single;
    }

    public void setSingle(Long single) {
        this.single.add(single);
    }

    public ArrayList<Integer> getTwoPlayer() {
        return TwoPlayer;
    }

    public void setTwoPlayer(int index) {
        TwoPlayer.set(index, TwoPlayer.get(index)+1);
    }

    public ArrayList<Integer> getThreePlayer() {
        return ThreePlayer;
    }

    public void setThreePlayer(int index) {
        ThreePlayer.set(index, ThreePlayer.get(index)+1);
    }

    public ArrayList<Integer> getFourPlayer() {
        return FourPlayer;
    }

    public void setFourPlayer(int index) {
        FourPlayer.set(index, FourPlayer.get(index)+1);
    }

}
