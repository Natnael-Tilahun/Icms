package com.example.icms.investmentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class IV_AppForm3 extends AppCompatActivity {
    Button CV_appform3next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v__app_form3);
        CV_appform3next_btn = findViewById(R.id.CV_appform3next_btn);
        CV_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IV_AppForm3.this, IV_AppForm4.class);
                startActivity(intent);
            }
        });

    }
}