package com.example.icms.foreignBusinessFirmEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class FV_AppForm4 extends AppCompatActivity {
    CardView FV_paywithcbe_cv, FV_paywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_v__app_form4);
        FV_paywithcbe_cv = findViewById(R.id.FV_paywithcbe_cv);
        FV_paywithcbebirr_cv = findViewById(R.id.FV_paywithcbebirr_cv);

        FV_paywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FV_AppForm4.this, FV_visapaywithcbe.class);
                startActivity(intent);
            }
        });

        FV_paywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FV_AppForm4.this, FV_visapaywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}