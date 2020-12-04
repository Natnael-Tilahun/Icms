package com.example.icms.touristVisaOnarrival;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class TouristVisa_onArrival extends AppCompatActivity {
    Button TV_onarrival_next_btn;
    EditText TVonarrival_citizenship_ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_visa_on_arrival);
        TV_onarrival_next_btn = findViewById(R.id.TV_onarrival_next_btn);
        TVonarrival_citizenship_ET = findViewById(R.id.TVonarrival_citizenship_ET);
        TV_onarrival_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String TVonarrival_citizenship = TVonarrival_citizenship_ET.getText().toString().trim();
        if (TVonarrival_citizenship.isEmpty()) {
            TVonarrival_citizenship_ET.setError("Please insert your CitizenShip!");
            TVonarrival_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(TouristVisa_onArrival.this, TV_onarrival_AppForm2.class);
            startActivity(intent);
        }
    }
}