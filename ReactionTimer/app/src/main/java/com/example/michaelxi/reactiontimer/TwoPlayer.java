package com.example.michaelxi.reactiontimer;
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
public class TwoPlayer extends Activity{
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
        //Get the view from twoplayer.xml
        setContentView(R.layout.twoplayer);

        Button player1=(Button) findViewById(R.id.playerOne);
        Button player2=(Button) findViewById(R.id.playerTwo);



        player1.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            //Source code was fetched and modified from http://stackoverflow.com/questions/26097513/android-simple-alert-dialog
            public void onClick(View arg0) {
                if (proceed == true) {
                    proceed=false;
                    record.setTwoPlayer(0);
                    saveInFile();
                    AlertDialog SinglePrompt = new AlertDialog.Builder(TwoPlayer.this).create();
                    SinglePrompt.setTitle("Result");
                    SinglePrompt.setMessage("Player 1 Buzz!");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                    proceed=true;
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
                if (proceed==true){
                    proceed=false;
                    record.setTwoPlayer(1);
                    saveInFile();
                    AlertDialog SinglePrompt = new AlertDialog.Builder(TwoPlayer.this).create();
                    SinglePrompt.setTitle("Result");
                    SinglePrompt.setMessage("Player 2 Buzz!");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                    proceed=true;
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
