package com.example.icms.governmentInstitutionsShortWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GIV_AppForm extends AppCompatActivity {
    Button GIV_appformnext_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_i_v__app_form);
        GIV_appformnext_btn = findViewById(R.id.GIV_appformnext_btn);
        GIV_appformnext_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GIV_AppForm.this, GIV_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}