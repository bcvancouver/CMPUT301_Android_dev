package com.example.michaelxi.reactiontimer;

/*Copyright (c) 2015 Michael Xi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by michaelximac on 2015-10-04.
 */
public class Record {
    //single-mode record is stored below
    ArrayList<Long> single= new ArrayList<Long>();
    //double-player mode record in the ArrayList below
    ArrayList<Integer> TwoPlayer= new ArrayList<>(Arrays.asList(0, 0));
    //triple-player mode record in the ArrayList below
    ArrayList<Integer> ThreePlayer= new ArrayList<>(Arrays.asList(0, 0, 0));
    //four-player mode record in the ArrayList below
    ArrayList<Integer> FourPlayer= new ArrayList<>(Arrays.asList(0, 0, 0, 0));

    //method of adding new reaction time
    public void setSingle(Long single) {
        this.single.add(single);
    }

    //method of recording buzz times
    public void setTwoPlayer(int index) {
        TwoPlayer.set(index, TwoPlayer.get(index)+1);
    }

    public void setThreePlayer(int index) {
        ThreePlayer.set(index, ThreePlayer.get(index)+1);
    }

    public void setFourPlayer(int index) {
        FourPlayer.set(index, FourPlayer.get(index)+1);
    }

    //method of looking up for buzz time record
    public Integer getTwoPlayer(int index) {
        return TwoPlayer.get(index);
    }

    public Integer getThreePlayer(int index) {
        return ThreePlayer.get(index);
    }

    public Integer getFourPlayer(int index) {
        return FourPlayer.get(index);
    }

    //Calculating minimum reaction time of last 10 or 100 records
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

    //Calculating maximum reaction time of last 10 or 100 records
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

    //Calculating average reaction time of last 10 or 100 records
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

    //Calculating median reaction time of last 10 or 100 records
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
