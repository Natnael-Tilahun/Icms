package com.example.icms.ethiopianGovernmentEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GV_AppForm4 extends AppCompatActivity {
    Button GV_appform4next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_v__app_form4);
        GV_appform4next_btn = findViewById(R.id.GV_appform4next_btn);
        GV_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GV_AppForm4.this, GV_AppForm5.class);
                startActivity(intent);
            }
        });
    }
}