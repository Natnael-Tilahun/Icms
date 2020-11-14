package com.example.icms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng Main_Department_For_Immigration_and_Nationality_Affairs = new LatLng(9.033703, 38.76199);
            LatLng Immigration_Office_Hawassa_Branch = new LatLng(7.048032, 38.483752);
            LatLng Immigration_Office_Diredawa_Branch = new LatLng(9.602270, 41.863385);
            LatLng Immigration_Office_Bahirdar_Branch = new LatLng(11.578323, 37.360165);
            LatLng Immigration_Office_Mekelle_Branch = new LatLng(13.497173, 39.466066);
            LatLng Immigration_Office_Dessie_Branch = new LatLng(11.129661, 39.636329);
            LatLng Immigration_Office_Afar_Branch = new LatLng(11.440047, 40.844144);
            LatLng Immigration_Office_Benishangul_Gumuz_Branch = new LatLng(10.055061, 34.547277);
            LatLng Immigration_Office_Harari_Branch = new LatLng(9.322165, 42.114715);
//            LatLng Immigration_Office_Harari_Branch = new LatLng(9.322165, 42.114715);
//            LatLng Immigration_Office_Harari_Branch = new LatLng(9.322165, 42.114715);


            googleMap.addMarker(new MarkerOptions().position(Main_Department_For_Immigration_and_Nationality_Affairs).title("Main Department For Immigration & Nationality Affairs"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Hawassa_Branch).title("Immigration Office Hawassa Branch"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Diredawa_Branch).title("Immigration Office Diredawa Branch"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Bahirdar_Branch).title("Immigration Office Bahirdar Branch"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Mekelle_Branch).title("Immigration Office Mekelle Branch"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Dessie_Branch).title("Immigration Office Dessie Branch"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Afar_Branch).title("Immigration Office Afar Branch"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Benishangul_Gumuz_Branch).title("Immigration Office Benishangul Gumuz Branch"));
            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Harari_Branch).title("Immigration Office Harari Branch"));
//            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Harari_Branch).title("Immigration Office Harari Branch"));
//            googleMap.addMarker(new MarkerOptions().position(Immigration_Office_Harari_Branch).title("Immigration Office Harari Branch"));

//            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Main_Department_For_Immigration_and_Nationality_Affairs, 15f));
//            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Immigration_Office_Hawassa_Branch,15f));
//            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Immigration_Office_Diredawa_Branch,15f));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

}