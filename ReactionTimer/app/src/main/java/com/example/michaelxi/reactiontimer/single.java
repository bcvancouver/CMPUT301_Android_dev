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


public class Single extends Activity {

    long startTime=0;
    long millisec=0;

    //fetched from http://stackoverflow.com/questions/4597690/android-timer-how
    Handler timerHandler= new Handler();
    Runnable timerRunnable= new Runnable() {
        @Override
        public void run() {
            Button Click=(Button)findViewById(R.id.click);
            millisec=System.currentTimeMillis()-startTime;
            Click.setBackgroundColor(Color.GREEN);
        };
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Get the view from single.xml
        setContentView(R.layout.single);
        startTime=System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 2000);
        Button Click=(Button)findViewById(R.id.click);
        Click.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                if (millisec<2000) {
                    AlertDialog SinglePrompt = new AlertDialog.Builder(Single.this).create();
                    SinglePrompt.setTitle("Warning");
                    SinglePrompt.setMessage("Don't Click too early");
                    SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Continue", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
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
