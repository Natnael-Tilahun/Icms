package com.example.icms.ethiopianGovernmentEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GV_AppForm3 extends AppCompatActivity {
    Button GV_appform3next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_v__app_form3);
        GV_appform3next_btn = findViewById(R.id.GV_appform3next_btn);
        GV_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GV_AppForm3.this, GV_AppForm4.class);
                startActivity(intent);
            }
        });
    }
}