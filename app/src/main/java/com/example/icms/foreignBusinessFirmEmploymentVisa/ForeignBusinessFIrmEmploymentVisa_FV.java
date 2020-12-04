package com.example.icms.foreignBusinessFirmEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class ForeignBusinessFIrmEmploymentVisa_FV extends AppCompatActivity {
    Button FV_next_btn;
    EditText FV_citizenship_ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreign_business_f_irm_employment_visa__f_v);
        FV_next_btn = findViewById(R.id.FV_next_btn);
        FV_citizenship_ET = findViewById(R.id.FV_citizenship_ET);

        FV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String FV_citizenship = FV_citizenship_ET.getText().toString().trim();
        if (FV_citizenship.isEmpty()) {
            FV_citizenship_ET.setError("Please insert your CitizenShip!");
            FV_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(ForeignBusinessFIrmEmploymentVisa_FV.this, FV_AppForm2.class);
            startActivity(intent);
        }
    }
}