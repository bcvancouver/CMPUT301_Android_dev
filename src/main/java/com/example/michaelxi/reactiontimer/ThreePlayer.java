package com.example.michaelxi.reactiontimer;

/*Copyright (c) 2015 Michael Xi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by michaelximac on 2015-10-04.
 */
public class ThreePlayer extends Activity {
    boolean proceed=true;
    Record record= new Record();
    final String FILENAME="file.sav";

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
        setContentView(R.layout.threeplayer);

        Button player1=(Button) findViewById(R.id.playerOne);
        Button player2=(Button) findViewById(R.id.playerTwo);
        Button player3=(Button) findViewById(R.id.playerThree);

        player1.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            //Source code was fetched and modified from http://stackoverflow.com/questions/26097513/android-simple-alert-dialog
            public void onClick(View arg0) {
                if (proceed == true) {
                    proceed = false;
                    record.setThreePlayer(0);
                    saveInFile();
                    AlertDialog SinglePrompt = new AlertDialog.Builder(ThreePlayer.this).create();
                    SinglePrompt.setTitle("Result");
                    SinglePrompt.setMessage("Player 1 Buzz!");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                    proceed = true;
                                    dialog.dismiss();
                                }
                            }
                    );
                    SinglePrompt.show();
                }
            }

        });

        player2.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            //Source code was fetched and modified from http://stackoverflow.com/questions/26097513/android-simple-alert-dialog
            public void onClick(View arg0) {
                if (proceed == true) {
                    proceed = false;
                    record.setThreePlayer(1);
                    saveInFile();
                    AlertDialog SinglePrompt = new AlertDialog.Builder(ThreePlayer.this).create();
                    SinglePrompt.setTitle("Result");
                    SinglePrompt.setMessage("Player 2 Buzz!");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                    proceed = true;
                                    dialog.dismiss();
                                }
                            }
                    );
                    SinglePrompt.show();

                }

            }
        });

        player3.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            //Source code was fetched and modified from http://stackoverflow.com/questions/26097513/android-simple-alert-dialog
            public void onClick(View arg0) {
                if (proceed == true) {
                    proceed = false;
                    record.setThreePlayer(2);
                    saveInFile();
                    AlertDialog SinglePrompt = new AlertDialog.Builder(ThreePlayer.this).create();
                    SinglePrompt.setTitle("Result");
                    SinglePrompt.setMessage("Player 3 Buzz!");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                    proceed = true;
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

