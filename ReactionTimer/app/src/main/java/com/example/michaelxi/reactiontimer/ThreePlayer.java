package com.example.michaelxi.reactiontimer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by michaelximac on 2015-10-04.
 */
public class ThreePlayer extends Activity {
    boolean proceed=true;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Get the view from threeplayer.xml
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

