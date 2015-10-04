package com.example.michaelxi.reactiontimer;

/*Copyright (c) 2015 Michael Xi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Buzzer extends Activity{

    //Button threeplayer=(Button)findViewById(R.id.threePlayers);
    //Button fourplayer=(Button)findViewById(R.id.fourPlayers);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Get the view from buzzer.xml
        setContentView(R.layout.buzzer);
        Button twoplayer=(Button)findViewById(R.id.twoPlayers);
        Button threeplayer=(Button)findViewById(R.id.threePlayers);
        Button fourplayer=(Button)findViewById(R.id.fourPlayers);

        twoplayer.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Buzzer.this, TwoPlayer.class);
                startActivity(myIntent);
            }
        });

        threeplayer.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Buzzer.this, ThreePlayer.class);
                startActivity(myIntent);
            }
        });

        fourplayer.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Buzzer.this, FourPlayer.class);
                startActivity(myIntent);
            }
        });


    }

}
