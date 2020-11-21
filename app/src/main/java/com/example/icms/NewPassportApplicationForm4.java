package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class NewPassportApplicationForm4 extends AppCompatActivity {
    MaterialCardView newpasspaywithcbebirr_cv, newpasspaywithcbe_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_application_form4);
        newpasspaywithcbebirr_cv = findViewById(R.id.newpassportpaywithcbebirr_cv);
        newpasspaywithcbe_cv = findViewById(R.id.newpasspaywithcbe_cv);
        newpasspaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPassportApplicationForm4.this, NewPassportPayWithCBEBirr.class);
                startActivity(intent);
            }
        });
        newpasspaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPassportApplicationForm4.this, NewPassportPayWithCBE.class);
                startActivity(intent);
            }
        });

    }
}