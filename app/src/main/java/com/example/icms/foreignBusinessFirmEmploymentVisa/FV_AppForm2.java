package com.example.icms.foreignBusinessFirmEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class FV_AppForm2 extends AppCompatActivity {
    Button FV_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_v__app_form2);
        FV_appform2next_btn = findViewById(R.id.FV_appform2next_btn);
        FV_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FV_AppForm2.this, FV_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}