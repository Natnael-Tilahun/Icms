package com.example.icms.newpassport_process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.MainActivity;
import com.example.icms.R;

public class NewPassportPayWithCBE extends AppCompatActivity {
    Button pay_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_pay_with_c_b_e);

        pay_btn = findViewById(R.id.pay_btn);
        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPassportPayWithCBE.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}