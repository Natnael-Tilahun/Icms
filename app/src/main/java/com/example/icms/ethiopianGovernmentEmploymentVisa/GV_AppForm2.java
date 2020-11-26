package com.example.icms.ethiopianGovernmentEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GV_AppForm2 extends AppCompatActivity {
    Button GV_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_v__app_form2);
        GV_appform2next_btn = findViewById(R.id.GV_appform2next_btn);
        GV_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GV_AppForm2.this, GV_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}