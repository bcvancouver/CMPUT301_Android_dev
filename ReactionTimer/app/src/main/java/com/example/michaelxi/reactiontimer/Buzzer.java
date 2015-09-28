package com.example.michaelxi.reactiontimer;

/**
 * Created by michaelxi on 2015-09-28.
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;

public class Buzzer extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Get the view from buzzer.xml
        setContentView(R.layout.buzzer);
    }
}
