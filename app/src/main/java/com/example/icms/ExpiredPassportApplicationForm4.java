package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class ExpiredPassportApplicationForm4 extends AppCompatActivity {
    MaterialCardView expiredpasspaywithcbebirr_cv, expiredpasspaywithcbe_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_passport_application_form4);
        expiredpasspaywithcbebirr_cv = findViewById(R.id.expiredpasspaywithcbebirr_cv);
        expiredpasspaywithcbe_cv = findViewById(R.id.expiredpasspaywithcbe_cv);

        expiredpasspaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpiredPassportApplicationForm4.this, ExpiredPassportPayWithCBEBirr.class);
                startActivity(intent);
            }
        });

        expiredpasspaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpiredPassportApplicationForm4.this, ExpiredPassportPayWithCBE.class);
                startActivity(intent);
            }
        });

    }
}