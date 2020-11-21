package com.example.icms.lostpassport_process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.material.card.MaterialCardView;

public class LostPassportApplicationForm4 extends AppCompatActivity {
    MaterialCardView lostpasspaywithcbebirr_cv, lostpasspaywithcbe_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_passport_application_form4);
        lostpasspaywithcbebirr_cv = findViewById(R.id.lostpassportpaywithcbebirr_cv);
        lostpasspaywithcbe_cv = findViewById(R.id.lostpassportpaywithcbe_cv);
        lostpasspaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LostPassportApplicationForm4.this, LostPassportPayWithCBEBirr.class);
                startActivity(intent);
            }
        });
        lostpasspaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LostPassportApplicationForm4.this, LostPassportPayWithCBE.class);
                startActivity(intent);
            }
        });

    }
}