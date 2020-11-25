package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ForeignBusinessFIrmEmploymentVisa_FV extends AppCompatActivity {
    Button FV_next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreign_business_f_irm_employment_visa__f_v);
        FV_next_btn = findViewById(R.id.FV_next_btn);
        FV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForeignBusinessFIrmEmploymentVisa_FV.this, FV_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}