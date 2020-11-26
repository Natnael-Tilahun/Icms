package com.example.icms.ethiopianPrivateBusinessFirmWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class PE_AppForm3 extends AppCompatActivity {
    Button PE_appform3next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_e__app_form3);
        PE_appform3next_btn = findViewById(R.id.PE_appform3next_btn);
        PE_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PE_AppForm3.this, PE_AppForm4.class);
                startActivity(intent);
            }
        });
    }
}