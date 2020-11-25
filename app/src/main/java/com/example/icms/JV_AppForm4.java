package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JV_AppForm4 extends AppCompatActivity {
    Button JV_appform4next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_v__app_form4);
        JV_appform4next_btn = findViewById(R.id.JV_appform4next_btn);
        JV_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JV_AppForm4.this, JV_AppForm5.class);
                startActivity(intent);
            }
        });
    }
}