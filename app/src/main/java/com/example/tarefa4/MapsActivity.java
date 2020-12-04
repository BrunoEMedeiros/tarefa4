package com.example.tarefa4;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tarefa4.MainActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String nome;
    Double lat;
    Double lgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        /*Bundle b = getIntent().getExtras();
        if(b != null){

            lat = (Double) b.get("Lat");
            lgt = (Double) b.get("Lgn");
        }

        LatLng sydney = new LatLng(lat, lgt);


         */

        // Add a marker in Sydney and move the camera

        LatLng Angola = new LatLng(-12.5, 18.5);

        LatLng Brazil = new LatLng(-10.0, -55.0);

        LatLng CaboVerde = new LatLng(16.0, -24.0);

        LatLng GuineaBissau = new LatLng(12.0, -15.0);

        LatLng Macao = new LatLng(22.16666666, 113.55);

        LatLng Mozambique = new LatLng(-18.25, 35.0);

        LatLng Portugal = new LatLng(39.5, -8.0);

        LatLng SaoTomeandPrincipe = new LatLng(1.0, 7.0);

        LatLng TimorLeste = new LatLng(-8.83333333, 125.91666666);

        mMap.addMarker(new MarkerOptions().position(Angola).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(Brazil).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(CaboVerde).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(GuineaBissau).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(Macao).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(Mozambique).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(Portugal).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(SaoTomeandPrincipe).title("Marker in Sydney"));

        mMap.addMarker(new MarkerOptions().position(TimorLeste).title("Marker in Sydney"));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}