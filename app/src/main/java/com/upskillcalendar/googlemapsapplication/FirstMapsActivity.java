package com.upskillcalendar.googlemapsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FirstMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Delhi and move the camera
        LatLng markerLatLong = new LatLng(28.6139, 77.2090);
        mMap.setTrafficEnabled(true);
        // mMap.setMyLocationEnabled(true);  // ask the permission for GPS . GPS must be enable to work this function.
        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location))
                .position(markerLatLong).title("Marker at Delhi"));                                 // with custom marker
        //mMap.addMarker(new MarkerOptions().position(markerLatLong).title("Marker at Delhi"));     // without custom marker
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);                                                // 5 types of MapType in android
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(markerLatLong));                              // move camera to the location where there is marker
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.6139, 77.2090),10.0f));      // move and zoom to the location where zoom = 25 is the highest range
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.6139, 77.2090), 15.5f), 4000, null); // animate the camera with zoom
    }
}
