package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CV_AppForm2 extends AppCompatActivity {
    Button CV_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v__app_form2);
        CV_appform2next_btn = findViewById(R.id.CV_appform2next_btn);
        CV_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CV_AppForm2.this, CV_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}