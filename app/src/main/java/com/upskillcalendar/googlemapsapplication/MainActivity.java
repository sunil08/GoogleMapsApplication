package com.upskillcalendar.googlemapsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.upskillcalendar.googlemapsapplication.FirstApp.FirstMapsActivity;
import com.upskillcalendar.googlemapsapplication.SecondApp.SecondMapsActivity;
import com.upskillcalendar.googlemapsapplication.ThirdApp.GPSLocation;

public class MainActivity extends AppCompatActivity {

    Button buttonActivityone,buttonActivitytwo,ButtonActivitythree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonActivityone = (Button)findViewById(R.id.mapbutton1);
        buttonActivitytwo = (Button)findViewById(R.id.mapbutton2);
        ButtonActivitythree = (Button)findViewById(R.id.locationbutton);

        buttonActivityone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FirstMapsActivity.class));
            }
        });

        buttonActivitytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondMapsActivity.class));
            }
        });

        ButtonActivitythree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GPSLocation.class));
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
