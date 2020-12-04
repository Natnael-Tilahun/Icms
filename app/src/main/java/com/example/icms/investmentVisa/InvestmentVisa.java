package com.example.icms.investmentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class InvestmentVisa extends AppCompatActivity {
    Button IV_next_btn;
    EditText IV_citizenship_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_visa);
        IV_next_btn = findViewById(R.id.IV_next_btn);
        IV_citizenship_ET = findViewById(R.id.IV_citizenship_ET);

        IV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String IV_citizenship = IV_citizenship_ET.getText().toString().trim();
        if (IV_citizenship.isEmpty()) {
            IV_citizenship_ET.setError("Please insert your CitizenShip!");
            IV_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(InvestmentVisa.this, IV_AppForm2.class);
            startActivity(intent);
        }
    }
}