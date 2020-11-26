package com.example.icms.ethiopianPrivateBusinessFirmWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class PE_AppForm4 extends AppCompatActivity {
    Button PE_appform4next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_e__app_form4);
        PE_appform4next_btn = findViewById(R.id.PE_appform4next_btn);
        PE_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PE_AppForm4.this, PE_AppForm5.class);
                startActivity(intent);
            }
        });
    }
}