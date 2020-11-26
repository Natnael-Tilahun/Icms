package com.example.icms.touristVisaOnarrival;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class TouristVisa_onArrival extends AppCompatActivity {
    Button TV_onarrival_next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_visa_on_arrival);
        TV_onarrival_next_btn = findViewById(R.id.TV_onarrival_next_btn);
        TV_onarrival_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TouristVisa_onArrival.this, TV_onarrival_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}