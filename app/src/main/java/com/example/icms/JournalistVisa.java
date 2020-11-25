package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JournalistVisa extends AppCompatActivity {
    Button JV_next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journalist_visa);
        JV_next_btn = findViewById(R.id.JV_next_btn);
        JV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JournalistVisa.this, JV_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}