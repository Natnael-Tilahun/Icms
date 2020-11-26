package com.example.icms.NGOworkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class NGO_AppForm3 extends AppCompatActivity {
    Button NGO_appform3next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__app_form3);
        NGO_appform3next_btn = findViewById(R.id.NGO_appform3next_btn);
        NGO_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NGO_AppForm3.this, NGO_AppForm4.class);
                startActivity(intent);
            }
        });
    }
}