package com.example.icms.confrenceVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class CV_AppForm5 extends AppCompatActivity {
    Button CV_appform5next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v__app_form5);
        CV_appform5next_btn = findViewById(R.id.CV_appform5next_btn);
        CV_appform5next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CV_AppForm5.this, CV_AppForm6.class);
                startActivity(intent);
            }
        });


    }
}