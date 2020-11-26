package com.example.icms.governmentInstitutionsShortWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GovernmentInstitutionsShortWorkVisa_GIV extends AppCompatActivity {
    Button GIV_next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_institutions_short_work_visa__g_i_v);
        GIV_next_btn = findViewById(R.id.GIV_next_btn);
        GIV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GovernmentInstitutionsShortWorkVisa_GIV.this, GIV_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}