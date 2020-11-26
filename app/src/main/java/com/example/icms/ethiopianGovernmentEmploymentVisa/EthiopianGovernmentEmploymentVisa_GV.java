package com.example.icms.ethiopianGovernmentEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class EthiopianGovernmentEmploymentVisa_GV extends AppCompatActivity {
    Button GV_next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethiopian_government_employment_visa__g_v);
        GV_next_btn = findViewById(R.id.GV_next_btn);
        GV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EthiopianGovernmentEmploymentVisa_GV.this, GV_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}