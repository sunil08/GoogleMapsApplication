package com.upskillcalendar.googlemapsapplication.ThirdApp;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.upskillcalendar.googlemapsapplication.R;

import java.util.List;
import java.util.Locale;

public class GPSLocation extends AppCompatActivity {

    Button buttonlatlong;
    // GPSTracker class
    GPSTracker gps;
    TextView textViewAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpslocation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonlatlong = (Button)findViewById(R.id.latlong);
        textViewAddress = (TextView)findViewById(R.id.addressdata);

        buttonlatlong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(GPSLocation.this);

                // check if GPS enabled
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    Geocoder geocoder;
                    List<Address> addresses;
                    geocoder = new Geocoder(GPSLocation.this, Locale.getDefault());

                    try {
                        addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

                        Log.e("address size ",""+addresses.size());
                        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                        String city = addresses.get(0).getLocality();
                        String state = addresses.get(0).getAdminArea();
                        String country = addresses.get(0).getCountryName();
                        String postalCode = addresses.get(0).getPostalCode();
                        String knownName = addresses.get(0).getFeatureName();

                        String strAdd="";
                        Address address1 = addresses.get(0);
                        StringBuilder strReturnedAddress = new StringBuilder("");

                        for (int i = 0; i < address1.getMaxAddressLineIndex(); i++) {
                            strReturnedAddress.append(address1.getAddressLine(i)).append("\n");
                        }
                        strAdd = strReturnedAddress.toString();

                        textViewAddress.setText(strAdd);
                        Log.e("strAdd ",strAdd);
                        Log.e("address ",address);
                        //Toast.makeText(getApplicationContext(),address , Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e){
                        Log.e("address ","no address");
                        //Toast.makeText(getApplicationContext(), "Nothing", Toast.LENGTH_LONG).show();
                    }

                    // \n is for new line
                    // Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });
    }

}
