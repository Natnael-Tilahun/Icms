package com.example.icms.investmentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class IV_AppForm5 extends AppCompatActivity {
    CardView IV_visapaywithcbe_cv, IV_visapaywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v__app_form5);
        IV_visapaywithcbe_cv = findViewById(R.id.IV_visapaywithcbe_cv);
        IV_visapaywithcbebirr_cv = findViewById(R.id.IV_visapaywithcbebirr_cv);

        IV_visapaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IV_AppForm5.this, IV_paywithcbe.class);
                startActivity(intent);
            }
        });

        IV_visapaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IV_AppForm5.this, IV_paywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}