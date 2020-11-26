package com.example.icms.confrenceVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class CV_AppForm6 extends AppCompatActivity {
    CardView CV_paywithcbe_cv, CV_paywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v__app_form6);
        CV_paywithcbe_cv = findViewById(R.id.CV_paywithcbe_cv);
        CV_paywithcbebirr_cv = findViewById(R.id.CV_paywithcbebirr_cv);

        CV_paywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CV_AppForm6.this, CV_paywithcbe.class);
                startActivity(intent);
            }
        });

        CV_paywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CV_AppForm6.this, CV_paywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}