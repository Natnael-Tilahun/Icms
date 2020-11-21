package com.example.icms.urgentpassport_process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.material.card.MaterialCardView;

public class UrgentPassportAppliacationForm4 extends AppCompatActivity {
    MaterialCardView urgentpasspaywithcbebirr_cv, urgentpasspaywithcbe_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_passport_appliacation_form4);
        urgentpasspaywithcbebirr_cv = findViewById(R.id.urgentpasspaywithcbebirr_cv);
        urgentpasspaywithcbe_cv = findViewById(R.id.urgentpasspaywithcbe_cv);
        urgentpasspaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UrgentPassportAppliacationForm4.this, UrgentPassportPayWithCBEBirr.class);
                startActivity(intent);
            }
        });
        urgentpasspaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UrgentPassportAppliacationForm4.this, UrgentPassportPayWithCBE.class);
                startActivity(intent);
            }
        });

    }
}