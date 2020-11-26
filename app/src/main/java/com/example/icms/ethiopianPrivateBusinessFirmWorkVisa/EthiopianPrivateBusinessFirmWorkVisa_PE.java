package com.example.icms.ethiopianPrivateBusinessFirmWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class EthiopianPrivateBusinessFirmWorkVisa_PE extends AppCompatActivity {
    Button PE_next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethiopian_private_business_firm_work_visa__p_e);
        PE_next_btn = findViewById(R.id.PE_next_btn);
        PE_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EthiopianPrivateBusinessFirmWorkVisa_PE.this, PE_AppForm2.class);
                startActivity(intent);
            }
        });
    }
}