package com.example.icms.journalistVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class JV_AppForm5 extends AppCompatActivity {
    CardView JV_paywithcbe_cv, JV_paywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_v__app_form5);
        JV_paywithcbe_cv = findViewById(R.id.JV_paywithcbe_cv);
        JV_paywithcbebirr_cv = findViewById(R.id.JV_paywithcbebirr_cv);

        JV_paywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JV_AppForm5.this, JV_visapaywithcbe.class);
                startActivity(intent);
            }
        });
        JV_paywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JV_AppForm5.this, JV_visapaywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}