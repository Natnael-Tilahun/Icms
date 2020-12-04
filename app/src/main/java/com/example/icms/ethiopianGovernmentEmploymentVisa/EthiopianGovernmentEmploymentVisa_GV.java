package com.example.icms.ethiopianGovernmentEmploymentVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class EthiopianGovernmentEmploymentVisa_GV extends AppCompatActivity {
    Button GV_next_btn;
    EditText GV_citizenship_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethiopian_government_employment_visa__g_v);
        GV_next_btn = findViewById(R.id.GV_next_btn);
        GV_citizenship_ET = findViewById(R.id.GV_citizenship_ET);

        GV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String GV_citizenship = GV_citizenship_ET.getText().toString().trim();
        if (GV_citizenship.isEmpty()) {
            GV_citizenship_ET.setError("Please Insert Your CitizenShip!");
            GV_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(EthiopianGovernmentEmploymentVisa_GV.this, GV_AppForm2.class);
            startActivity(intent);
        }
    }
}