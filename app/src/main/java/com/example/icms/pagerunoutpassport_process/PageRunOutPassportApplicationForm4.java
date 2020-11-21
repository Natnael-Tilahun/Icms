package com.example.icms.pagerunoutpassport_process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.material.card.MaterialCardView;

public class PageRunOutPassportApplicationForm4 extends AppCompatActivity {
    MaterialCardView pagerunoutpasspaywithcbebirr_cv, pagerunoutpasspaywithcbe_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_run_out_passport_application_form4);
        pagerunoutpasspaywithcbebirr_cv = findViewById(R.id.pagerunoutpaywithcbebirr_cv);
        pagerunoutpasspaywithcbe_cv = findViewById(R.id.pagerunoutpaywithcbe_cv);
        pagerunoutpasspaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageRunOutPassportApplicationForm4.this, PassportPagerunoutPayWithCBEBirr.class);
                startActivity(intent);
            }
        });
        pagerunoutpasspaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageRunOutPassportApplicationForm4.this, PageRunOutPassportPayWithCBE.class);
                startActivity(intent);
            }
        });

    }
}