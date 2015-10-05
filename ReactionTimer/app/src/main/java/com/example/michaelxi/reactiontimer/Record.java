package com.example.michaelxi.reactiontimer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by michaelximac on 2015-10-04.
 */
public class Record {
    ArrayList<Long> single= new ArrayList<Long>();
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

    public Long getminresult(ArrayList<Long> single, int limit){
        ArrayList<Long> temp=new ArrayList<Long>();
        if (limit<single.size()){
            for (int i=single.size()-1; i>single.size()-10; i--){
                temp.add(single.get(i));
            }
            //Reference: http://www.tutorialspoint.com/java/util/collections_min_comparator.htm
            Long result=Collections.min(temp);
            return result;
        }else{
            Long result=Collections.min(single);
            return result;
        }
    }

    public Long getmaxresult(ArrayList<Long> single, int limit){
        ArrayList<Long> temp=new ArrayList<Long>();
        if (limit<single.size()){
            for (int i=single.size()-1; i>single.size()-10; i--){
                temp.add(single.get(i));
            }
            Long result=Collections.max(temp);
            return result;
        }else{
            Long result=Collections.max(single);
            return result;
        }
    }

    public Long getAverageResult(ArrayList<Long> single,int limit){
        ArrayList<Long> temp=new ArrayList<Long>();
        long sum=0;
        if (limit<single.size()){
            for (int i=single.size()-1; i>single.size()-10; i--){
                sum+=single.get(i);
            }
            return sum/limit;
        }else{
            for (Long singleTime: single){
                sum+=singleTime;
            }
            return sum/single.size();
        }

    }

    public Long getMedianResult(ArrayList<Long> single,int limit){
        ArrayList<Long> temp=new ArrayList<Long>();
        if (limit<single.size()){
            for (int i=single.size()-1; i>single.size()-10; i--) {
                temp.add(single.get(i));
            }
            Collections.sort(temp);
            return temp.get(limit/2);
        }else{
            for (Long singleTime: single){
                temp.add(singleTime);
            }
            Collections.sort(temp);
            return temp.get(temp.size()/2);
        }

    }
}
