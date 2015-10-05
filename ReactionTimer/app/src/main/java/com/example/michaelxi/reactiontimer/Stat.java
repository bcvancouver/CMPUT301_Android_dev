package com.example.michaelxi.reactiontimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*Copyright (c) 2015 Michael Xi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

public class Stat extends Activity{
    Record record= new Record();
    final String FILENAME="file.sav";

    @Override
    protected  void onStart(){
        super.onStart();

    }

    private void loadFromFile(){
        try{
            FileInputStream fis=openFileInput(FILENAME);
            BufferedReader in=new BufferedReader(new InputStreamReader(fis));
            Gson gson=new Gson();
            record=gson.fromJson(in,record.getClass());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Get the view from stat.xml
        setContentView(R.layout.stat);
        TextView statResult=(TextView)findViewById(R.id.statResult);
        loadFromFile();
        Button Click=(Button)findViewById(R.id.clear);
        Click.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            public void onClick(View arg0) {
                File dir=getFilesDir();
                File file=new File(dir,"file.sav");
                boolean deleted =file.delete();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        if (record.single.size()!=0){
            statResult.setText("Reaction Time Statistics:");
            statResult.append("\n  Minimum of last 10 reaction times: ");
            Long temptime=record.getminresult(record.single,10);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n  Minmum of last 100 reaction times: ");
            temptime=record.getminresult(record.single,100);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n  Maximum of last 10 reaction times: ");
            temptime=record.getmaxresult(record.single,10);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n  Maximum of last 100 reaction times: ");
            temptime=record.getmaxresult(record.single,100);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n  Average of last 10 reaction times: ");
            temptime=record.getAverageResult(record.single,10);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n  Average of last 100 reaction times: ");
            temptime=record.getAverageResult(record.single,100);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n  Median of last 10 reaction times: ");
            temptime=record.getMedianResult(record.single,10);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n  Median of last 100 reaction times: ");
            temptime=record.getMedianResult(record.single,100);
            statResult.append(temptime.toString());
            statResult.append(" miliseconds\n");


        } else {
            statResult.setText("  Single User record not found. ");
        }

        //Buzzer Count Stats
        statResult.append("\nBuzzer Counts:\n");
        if (record.TwoPlayer.size()!=0){
            statResult.append("  2 Players:\n    Player 1 Buzzes: "+record.getTwoPlayer(0).toString());
            statResult.append("\n    Player 2 Buzzes: " + record.getTwoPlayer(1).toString()+"\n");
        } else {
            statResult.append("  Record not found. ");
        }

        if (record.ThreePlayer.size()!=0){
            statResult.append("  3 Players:\n    Player 1 Buzzes: "+record.getThreePlayer(0).toString());
            statResult.append("\n    Player 2 Buzzes: " + record.getThreePlayer(1).toString()+"\n");
            statResult.append("    Player 3 Buzzes: " + record.getThreePlayer(2).toString()+"\n");

        }else{
            statResult.append("  Record not found. ");
        }

        if (record.FourPlayer.size()!=0){
            statResult.append("  4 Players:\n    Player 1 Buzzes: "+record.getFourPlayer(0).toString());
            statResult.append("\n    Player 2 Buzzes: " + record.getFourPlayer(1).toString()+"\n");
            statResult.append("    Player 3 Buzzes: " + record.getFourPlayer(2).toString()+"\n");
            statResult.append("    Player 4 Buzzes: " + record.getFourPlayer(3).toString()+"\n");
        }else{
            statResult.append("  Record not found. ");
        }
    }
}
