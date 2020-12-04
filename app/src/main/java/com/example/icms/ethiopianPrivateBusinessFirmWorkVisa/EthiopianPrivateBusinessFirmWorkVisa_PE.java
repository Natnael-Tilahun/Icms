package com.example.icms.ethiopianPrivateBusinessFirmWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class EthiopianPrivateBusinessFirmWorkVisa_PE extends AppCompatActivity {
    Button PE_next_btn;
    EditText PE_citizenship_ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethiopian_private_business_firm_work_visa__p_e);
        PE_next_btn = findViewById(R.id.PE_next_btn);
        PE_citizenship_ET = findViewById(R.id.PE_citizenship_ET);

        PE_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String PE_citizenship = PE_citizenship_ET.getText().toString().trim();
        if (PE_citizenship.isEmpty()) {
            PE_citizenship_ET.setError("Please insert your CitizenShip!");
            PE_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(EthiopianPrivateBusinessFirmWorkVisa_PE.this, PE_AppForm2.class);
            startActivity(intent);
        }
    }
}