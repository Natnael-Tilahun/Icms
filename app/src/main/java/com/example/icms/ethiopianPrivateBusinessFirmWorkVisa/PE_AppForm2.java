package com.example.icms.ethiopianPrivateBusinessFirmWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class PE_AppForm2 extends AppCompatActivity {
    Button PE_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_e__app_form2);
        PE_appform2next_btn = findViewById(R.id.PE_appform2next_btn);
        PE_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PE_AppForm2.this, PE_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}