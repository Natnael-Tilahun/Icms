package com.example.icms.ethiopianGovernmentEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class GV_AppForm5 extends AppCompatActivity {
    CardView GV_visapaywithcbe_cv, GV_visapaywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_v__app_form5);
        GV_visapaywithcbe_cv = findViewById(R.id.GV_visapaywithcbe_cv);
        GV_visapaywithcbebirr_cv = findViewById(R.id.GV_visapaywithcbebirr_cv);

        GV_visapaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GV_AppForm5.this, GV_visapaywithcbe.class);
                startActivity(intent);
            }
        });

        GV_visapaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GV_AppForm5.this, GV_visapaywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}