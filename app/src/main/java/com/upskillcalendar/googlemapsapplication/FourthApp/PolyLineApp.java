package com.upskillcalendar.googlemapsapplication.FourthApp;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.upskillcalendar.googlemapsapplication.R;

import java.util.ArrayList;

public class PolyLineApp extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap map;
    SupportMapFragment mapFragment;
    ArrayList<LatLng> points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poly_line_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        points = new ArrayList<LatLng>();
        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map3);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(PolyLineApp.this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(PolyLineApp.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.6139, 77.2090), 16));
        map.addPolyline(new PolylineOptions().geodesic(true).add(new LatLng(28.683730, 77.009433))
                .add(new LatLng(28.632860, 77.219611)).add(new LatLng(28.644880, 77.263910)).add(new LatLng(28.671748, 77.333933)));

        // Setting OnClick event listener for the Google Map
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {

                // Instantiating the class MarkerOptions to plot marker on the map
                MarkerOptions markerOptions = new MarkerOptions();

                // Setting latitude and longitude of the marker position
                markerOptions.position(point);

                // Setting titile of the infowindow of the marker
                markerOptions.title("Position");

                // Setting the content of the infowindow of the marker
                markerOptions.snippet("Latitude:"+point.latitude+","+"Longitude:"+point.longitude);

                // Instantiating the class PolylineOptions to plot polyline in the map
                PolylineOptions polylineOptions = new PolylineOptions();

                // Setting the color of the polyline
                polylineOptions.color(Color.RED);

                // Setting the width of the polyline
                polylineOptions.width(3);

                // Adding the taped point to the ArrayList
                points.add(point);

                // Setting points of polyline
                polylineOptions.addAll(points);

                // Adding the polyline to the map
                map.addPolyline(polylineOptions);

                // Adding the marker to the map
                map.addMarker(markerOptions);

            }
        });

        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

            @Override
            public void onMapLongClick(LatLng point) {
                // Clearing the markers and polylines in the google map
                map.clear();

                // Empty the array list
                points.clear();
            }
        });
    }
}
