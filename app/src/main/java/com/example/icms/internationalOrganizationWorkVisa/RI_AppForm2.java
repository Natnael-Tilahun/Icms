package com.example.icms.internationalOrganizationWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class RI_AppForm2 extends AppCompatActivity {
    Button RI_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_i__app_form2);
        RI_appform2next_btn = findViewById(R.id.RI_appform2next_btn);
        RI_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RI_AppForm2.this, RI_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}