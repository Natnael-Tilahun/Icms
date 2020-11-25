package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InternationalOrganizationWorkVisa_RI extends AppCompatActivity {
    Button RI_next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international_organization_work_visa__r_i);
        RI_next_btn = findViewById(R.id.RI_next_btn);
        RI_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InternationalOrganizationWorkVisa_RI.this, RI_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}