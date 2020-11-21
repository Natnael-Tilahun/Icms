package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class DamagedPassportApplicatonForm4 extends AppCompatActivity {
    MaterialCardView damagedpasspaywithcbebirr_cv, damagedpasspaywithcbe_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damaged_passport_applicaton_form4);
        damagedpasspaywithcbebirr_cv = findViewById(R.id.damagedpasspaywithcbebirr_cv);
        damagedpasspaywithcbe_cv = findViewById(R.id.damagedpasspaywithcbe_cv);
        damagedpasspaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DamagedPassportApplicatonForm4.this, DamagedPassportPayWithCBEBirr.class);
                startActivity(intent);
            }
        });

        damagedpasspaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DamagedPassportApplicatonForm4.this, DamagedPassportPayWithCBE.class);
                startActivity(intent);
            }
        });

    }
}