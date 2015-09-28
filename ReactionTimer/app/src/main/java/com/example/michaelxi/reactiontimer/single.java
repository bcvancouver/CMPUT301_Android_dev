package com.example.michaelxi.reactiontimer;
/**
 * Created by michaelximac on 15-09-27.
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;

public class Single extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Get the view from single.xml
        setContentView(R.layout.single);
    }

}
