package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IV_AppForm4 extends AppCompatActivity {
    Button IV_appform4next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v__app_form4);
        IV_appform4next_btn = findViewById(R.id.IV_appform4next_btn);
        IV_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IV_AppForm4.this, IV_AppForm5.class);
                startActivity(intent);
            }
        });
    }
}