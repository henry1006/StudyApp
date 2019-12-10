package com.example.duynguyen.studyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


    /**
     * An activity that displays a Google map with a marker (pin) to indicate a particular location.
     */
    public class Maps extends AppCompatActivity
            implements OnMapReadyCallback, OnMarkerClickListener {
        private GoogleMap mMap;
private Marker marker1;
        private Marker marker2;
        private Marker marker3;
private Button button;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Retrieve the content view that renders the map.
            setContentView(R.layout.activity_maps);
            // Get the SupportMapFragment and request notification
            // when the map is ready to be used.
            button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity2();
                }
            });
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);

            mapFragment.getMapAsync(this);


        }

        /**
         * Manipulates the map when it's available.
         * The API invokes this callback when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user receives a prompt to install
         * Play services inside the SupportMapFragment. The API invokes this method after the user has
         * installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady( GoogleMap  googleMap) {
            // Add a marker in Sydney, Australia,
            // and move the map's camera to the same location.
            mMap=googleMap;
            mMap.setOnMarkerClickListener(this);
            LatLng sydney = new LatLng(42.389812, -72.528252);
            LatLng sydney2 = new LatLng(42.389612, -72.528299);
            LatLng sydney3 = new LatLng(42.389612, -72.528200);

            marker1=mMap.addMarker(new MarkerOptions().position(sydney)
                    .title("Dubois LLC"));
            marker2=mMap.addMarker(new MarkerOptions().position(sydney2)
                    .title("Dubois Cafe"));
            marker3=mMap.addMarker(new MarkerOptions().position(sydney3)
                    .title("Dubois 23rd Floor"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,19.0f));
        }
        @Override
        public boolean onMarkerClick(final Marker marker) {
           if(marker.equals(marker1)) {
               openActivity3();
           }
           else if(marker.equals(marker2)) {
                openActivity4();
           }
           else if(marker.equals(marker3)) {
               openActivity5();
           }


            return true;

        }
        public void openActivity2() {
            Intent intent = new Intent(this, Page2.class);
            startActivity(intent);
        }
        public void openActivity3() {
            Intent intent = new Intent(this, LLC.class);
            startActivity(intent);
        }
        public void openActivity4() {
            Intent intent = new Intent(this, Cafe.class);
            startActivity(intent);
        }
        public void openActivity5() {
            Intent intent = new Intent(this, Floor.class);
            startActivity(intent);
        }


    }


