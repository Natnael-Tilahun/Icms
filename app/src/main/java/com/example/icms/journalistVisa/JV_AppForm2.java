package com.example.icms.journalistVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class JV_AppForm2 extends AppCompatActivity {
    Button JV_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_v__app_form2);
        JV_appform2next_btn = findViewById(R.id.JV_appform2next_btn);
        JV_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JV_AppForm2.this, JV_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}