package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NGOWorkVisa_NGO extends AppCompatActivity {
    Button NGO_next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o_work_visa__n_g_o);
        NGO_next_btn = findViewById(R.id.NGO_next_btn);
        NGO_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NGOWorkVisa_NGO.this, NGO_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}