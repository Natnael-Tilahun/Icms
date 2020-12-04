package com.example.icms.internationalOrganizationWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class InternationalOrganizationWorkVisa_RI extends AppCompatActivity {
    Button RI_next_btn;
    EditText RI_citizenship_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international_organization_work_visa__r_i);
        RI_next_btn = findViewById(R.id.RI_next_btn);
        RI_citizenship_ET = findViewById(R.id.RI_citizenship_ET);

        RI_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String RI_citizenship = RI_citizenship_ET.getText().toString().trim();
        if (RI_citizenship.isEmpty()) {
            RI_citizenship_ET.setError("Please insert your CitizenShip!");
            RI_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(InternationalOrganizationWorkVisa_RI.this, RI_AppForm2.class);
            startActivity(intent);
        }
    }
}