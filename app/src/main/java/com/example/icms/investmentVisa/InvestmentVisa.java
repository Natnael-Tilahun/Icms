package com.example.icms.investmentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class InvestmentVisa extends AppCompatActivity {
    Button IV_next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_visa);
        IV_next_btn = findViewById(R.id.IV_next_btn);
        IV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InvestmentVisa.this, IV_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}