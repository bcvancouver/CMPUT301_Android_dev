package com.example.michaelxi.reactiontimer;

/*Copyright (c) 2015 Michael Xi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Single extends Activity {

    long startTime=0;
    long millisec=0;
    long randomTime=0;

    Record record= new Record();
    private static final String FILENAME="file.sav";

    //fetched from http://stackoverflow.com/questions/4597690/android-timer-how
    Handler timerHandler= new Handler();
    Runnable timerRunnable= new Runnable() {
        @Override
        public void run() {
            Button Click=(Button)findViewById(R.id.click);
            millisec=System.currentTimeMillis()-startTime;
            Click.setBackgroundColor(Color.GREEN);
            startTime=System.currentTimeMillis();
        };
    };

    public long randomtime(long min, long max){
        double minf= (double) min;
        double maxf= (double) max;
        double randNum = ((maxf-minf)*(Math.random()))+minf;
        long randomnum;
        randomnum=(long)randNum;
        return randomnum;
    }
    //Followed lonelyTwitter example.
    @Override
    protected  void onStart(){
        super.onStart();
        loadFromFile();
        if (record==null){
            throw new RuntimeException();
        }
    }

    private void loadFromFile(){
        try{
            FileInputStream fis=openFileInput(FILENAME);
            BufferedReader in=new BufferedReader(new InputStreamReader(fis));
            Gson gson=new Gson();
            record=gson.fromJson(in,record.getClass());
        }catch (FileNotFoundException e){

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private  void saveInFile(){
        try{
            FileOutputStream fos=openFileOutput(FILENAME, 0);
            OutputStreamWriter writer=new OutputStreamWriter(fos);
            Gson gson=new Gson();
            gson.toJson(record,writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        //Get the view from single.xml
        setContentView(R.layout.single);
        startTime=System.currentTimeMillis();
        randomTime=randomtime(10, 2000);
        timerHandler.postDelayed(timerRunnable, randomTime);
        Button Click=(Button)findViewById(R.id.click);
        Click.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                if (millisec < randomTime) {
                    AlertDialog SinglePrompt = new AlertDialog.Builder(Single.this).create();
                    SinglePrompt.setTitle("Warning");
                    SinglePrompt.setMessage("Don't Click too early");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Restart single user mode (current activity)
                                    //Copied from http://stackoverflow.com/questions/1397361/how-do-i-restart-an-android-activity
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);

                                    dialog.dismiss();
                                }
                            }
                    );
                    SinglePrompt.show();
                } else {
                    millisec = System.currentTimeMillis() - startTime;
                    AlertDialog SinglePrompt = new AlertDialog.Builder(Single.this).create();
                    SinglePrompt.setTitle("Your Reaction Time");
                    Long val = new Long(millisec);
                    record.setSingle(val);
                    saveInFile();
                    String message = val.toString();
                    SinglePrompt.setMessage(message + " Millisecond");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Copied from http://stackoverflow.com/questions/1397361/how-do-i-restart-an-android-activity
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);

                                    dialog.dismiss();
                                }
                            }
                    );
                    SinglePrompt.show();
                }

            }
        });
    }



}
