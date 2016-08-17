package com.upskillcalendar.googlemapsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.upskillcalendar.googlemapsapplication.FifthApp.MapMarkerAtCenter;
import com.upskillcalendar.googlemapsapplication.FirstApp.FirstMapsActivity;
import com.upskillcalendar.googlemapsapplication.FourthApp.PolyLineApp;
import com.upskillcalendar.googlemapsapplication.SecondApp.SecondMapsActivity;
import com.upskillcalendar.googlemapsapplication.SeventhApp.LiteMapList;
import com.upskillcalendar.googlemapsapplication.SixthApp.LiteModeMaps;
import com.upskillcalendar.googlemapsapplication.ThirdApp.GPSLocation;

public class MainActivity extends AppCompatActivity {

    Button buttonActivityone,buttonActivitytwo,ButtonActivitythree,ButtonActivityfour,ButtonActivityfive, buttonActivitysix, buttonActiityseven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonActivityone = (Button)findViewById(R.id.mapbutton1);
        buttonActivitytwo = (Button)findViewById(R.id.mapbutton2);
        ButtonActivitythree = (Button)findViewById(R.id.locationbutton);
        ButtonActivityfour = (Button)findViewById(R.id.polylinebtn);
        ButtonActivityfive = (Button)findViewById(R.id.mapbutton5);
        buttonActivitysix = (Button)findViewById(R.id.mapbutton6);
        buttonActiityseven = (Button)findViewById(R.id.mapbutton7);

        buttonActivityone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FirstMapsActivity.class));       // First App Package
            }
        });

        buttonActivitytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondMapsActivity.class));      // Second App Package
            }
        });

        ButtonActivitythree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GPSLocation.class));             // Third App Package
            }
        });

        ButtonActivityfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PolyLineApp.class));             // Fourth App Package
            }
        });

        ButtonActivityfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MapMarkerAtCenter.class));       // Fifth App Package
            }
        });

        buttonActivitysix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LiteModeMaps.class));       // Fifth App Package
            }
        });

        buttonActiityseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LiteMapList.class));       // Fifth App Package
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
