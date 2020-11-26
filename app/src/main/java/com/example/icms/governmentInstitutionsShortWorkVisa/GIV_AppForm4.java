package com.example.icms.governmentInstitutionsShortWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class GIV_AppForm4 extends AppCompatActivity {
    CardView GIV_visapaywithcbe_cv, GIV_visapaywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_i_v__app_form4);
        GIV_visapaywithcbe_cv = findViewById(R.id.GIV_visapaywithcbe_cv);
        GIV_visapaywithcbebirr_cv = findViewById(R.id.GIV_visapaywithcbebirr_cv);

        GIV_visapaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GIV_AppForm4.this, GIV_visapaywithcbe.class);
                startActivity(intent);
            }
        });

        GIV_visapaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GIV_AppForm4.this, GIV_visapaywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}