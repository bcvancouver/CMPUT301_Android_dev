package com.example.michaelxi.reactiontimer;

import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by michaelximac on 2015-10-04.
 */
public class Record {
    ArrayList <Long> single= new ArrayList<Long>();
    public ArrayList<Long> getSingle() {
        return single;
    }

    public void setSingle(Long single) {
        this.single.add(single);
    }

}
