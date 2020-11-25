package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IV_AppForm2 extends AppCompatActivity {
    Button IV_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v__app_form2);
        IV_appform2next_btn = findViewById(R.id.IV_appform2next_btn);
        IV_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IV_AppForm2.this, IV_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}