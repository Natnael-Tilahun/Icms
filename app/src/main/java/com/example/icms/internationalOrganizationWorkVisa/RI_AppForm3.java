package com.example.icms.internationalOrganizationWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class RI_AppForm3 extends AppCompatActivity {
    Button RI_appform3next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_i__app_form3);
        RI_appform3next_btn = findViewById(R.id.RI_appform3next_btn);
        RI_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RI_AppForm3.this, RI_AppForm4.class);
                startActivity(intent);
            }
        });
    }
}