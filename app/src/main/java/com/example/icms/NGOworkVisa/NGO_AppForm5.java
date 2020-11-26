package com.example.icms.NGOworkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class NGO_AppForm5 extends AppCompatActivity {
    CardView NGO_visapaywithcbe_cv, NGO_visapaywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__app_form5);
        NGO_visapaywithcbe_cv = findViewById(R.id.NGO_visapaywithcbe_cv);
        NGO_visapaywithcbebirr_cv = findViewById(R.id.NGO_visapaywithcbebirr_cv);

        NGO_visapaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NGO_AppForm5.this, NGO_visapaywithcbe.class);
                startActivity(intent);
            }
        });
        NGO_visapaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NGO_AppForm5.this, NGO_visapaywithcbebirr.class);
                startActivity(intent);
            }
        });
    }
}