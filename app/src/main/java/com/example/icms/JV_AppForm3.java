package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JV_AppForm3 extends AppCompatActivity {
    Button JV_appform3next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_v__app_form3);
        JV_appform3next_btn = findViewById(R.id.JV_appform3next_btn);
        JV_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JV_AppForm3.this, FV_AppForm4.class);
                startActivity(intent);
            }
        });
    }
}