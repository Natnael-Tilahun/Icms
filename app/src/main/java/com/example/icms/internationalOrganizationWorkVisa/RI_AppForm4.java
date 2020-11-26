package com.example.icms.internationalOrganizationWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class RI_AppForm4 extends AppCompatActivity {
    CardView RI_visapaywithcbe_cv, RI_visapaywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_i__app_form4);
        RI_visapaywithcbe_cv = findViewById(R.id.RI_visapaywithcbe_cv);
        RI_visapaywithcbebirr_cv = findViewById(R.id.RI_visapaywithcbebirr_cv);
        RI_visapaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RI_AppForm4.this, RI_visapaywithcbe.class);
                startActivity(intent);
            }
        });

        RI_visapaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RI_AppForm4.this, RI_visapaywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}