package com.example.icms.touristVisaOnline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class TV_onlineAppForm4 extends AppCompatActivity {
    CardView TV_onlinepaywithcbe_cv, TV_onlinepaywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_online_app_form4);
        TV_onlinepaywithcbe_cv = findViewById(R.id.TV_onlinepaywithcbe_cv);
        TV_onlinepaywithcbebirr_cv = findViewById(R.id.TV_onlinepaywithcbebirr_cv);

        TV_onlinepaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TV_onlineAppForm4.this, TV_onlinepaywithcbe.class);
                startActivity(intent);
            }
        });

        TV_onlinepaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TV_onlineAppForm4.this, TV_onlinepaywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}