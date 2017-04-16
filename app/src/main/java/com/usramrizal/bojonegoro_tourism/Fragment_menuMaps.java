package com.usramrizal.bojonegoro_tourism;

import android.Manifest;
import android.app.Fragment;
import android.content.ClipData;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by amrizalns on 3/25/17.
 */

public class Fragment_menuMaps extends android.support.v4.app.Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MapView mapView;

    ClipData.Item nav_map;
    GPSTracker gpsTracker;
    private GPSTracker gps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_maps, container, false);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mapView = (MapView) view.findViewById(R.id.maps);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        gps = new GPSTracker(getActivity());

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if(gps.canGetLocation()){

                double lat = gps.getLatitude();
                double lang = gps.getLongitude();

                // \n is for new line
                Log.i("Lat", lat+"");
                Log.i("Lang", lang+"");
//            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
            }else{
                // can't get location
                // GPS or Network is not enabled
                // Ask user to enable GPS/network in settings
                gps.showSettingsAlert();
            }
//
//            double lat = gpsTracker.getLatitude();
//            double lang = gpsTracker.getLongitude();
//            Log.i("Lat", lat+"");
//            Log.i("Lang", lang+"");
//            LatLng latLng = new LatLng(lat, lang);
            return;
        }

        mMap = googleMap;
        mMap.setMyLocationEnabled(true);



        mMap.setTrafficEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 7));
//        mMap.addMarker(new MarkerOptions().position(latlng).title(""));
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

            @Override
            public void onMapLongClick(LatLng point) {
                mMap.addMarker(new MarkerOptions().position(point).title("").snippet(""));
            }
        });
    }
}

