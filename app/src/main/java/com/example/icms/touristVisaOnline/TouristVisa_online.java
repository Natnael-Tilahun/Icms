package com.example.icms.touristVisaOnline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

import java.util.ArrayList;

public class TouristVisa_online extends AppCompatActivity {
    Spinner sp_TV_online;
    Button TV_online_next_btn;
    EditText TVonline_citizenship_ET;

    ArrayList<String> arrayList_TV_citizenship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_visa_online);
        TV_online_next_btn = findViewById(R.id.TV_online_next_btn);
        TVonline_citizenship_ET = findViewById(R.id.TVonline_citizenship_ET);

        TV_online_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String TVonline_citizenship = TVonline_citizenship_ET.getText().toString().trim();
        if (TVonline_citizenship.isEmpty()) {
            TVonline_citizenship_ET.setError("Please insert your CitizenShip!");
            TVonline_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(TouristVisa_online.this, TV_onlineAppForm2.class);
            startActivity(intent);
        }
    }
}
