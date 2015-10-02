/*Copyright (c) 2015 Michael Xi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

package com.example.michaelxi.reactiontimer;

//import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
//fetched from http://www.androidbegin.com/tutorial/android-button-click-new-activity-example/
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
//fetched from http://www.androidbegin.com/tutorial/android-button-click-new-activity-example/
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fetched from http://www.androidbegin.com/tutorial/android-button-click-new-activity-example/
        //locate the button in activity_main.xml
        Button Single= (Button) findViewById(R.id.Single);
        Button Buzzer=(Button) findViewById(R.id.Buzzer);
        Button Stat=(Button) findViewById(R.id.Stats);

        //Capture button clicks.
        Single.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            //Source code was fetched and modified from http://stackoverflow.com/questions/26097513/android-simple-alert-dialog
            public void onClick(View arg0) {
                AlertDialog SinglePrompt= new AlertDialog.Builder(MainActivity.this).create();
                SinglePrompt.setTitle("Attention");
                SinglePrompt.setMessage("Plz wait until you see the Click button turn green");
                SinglePrompt.setButton(AlertDialog.BUTTON_NEUTRAL, "Continue",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int which){
                                //Start single.class
                                Intent myIntent = new Intent(MainActivity.this, Single.class);
                                startActivity(myIntent);
                                dialog.dismiss();
                            }
                }
                );
                SinglePrompt.show();

            }
        });

        Buzzer.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            public void onClick(View arg0) {
                //Start single.class
                Intent myIntent = new Intent(MainActivity.this, Buzzer.class);
                startActivity(myIntent);
            }
        });

        Stat.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            public void onClick(View arg0) {
                //Start single.class
                Intent myIntent = new Intent(MainActivity.this, Stat.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
