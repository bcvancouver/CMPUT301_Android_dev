package com.example.michaelxi.reactiontimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//fetched from http://www.androidbegin.com/tutorial/android-button-click-new-activity-example/
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
//fetched from http://www.androidbegin.com/tutorial/android-button-click-new-activity-example/
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fetched from http://www.androidbegin.com/tutorial/android-button-click-new-activity-example/
        //locate the button in activity_main.xml
        Button Single= (Button) findViewById(R.id.Single);

        //Capture button clicks.
        Single.setOnClickListener(new Button.OnClickListener() {
            // Navigating to another activity.
            public void onClick(View arg0) {
                //Start single.class
                Intent myIntent = new Intent(MainActivity.this, Single.class);
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
